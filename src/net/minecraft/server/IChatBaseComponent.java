package net.minecraft.server;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public interface IChatBaseComponent extends Iterable<IChatBaseComponent> {

	IChatBaseComponent setChatModifier(ChatModifier var1);

	ChatModifier getChatModifier();

	IChatBaseComponent a(String var1);

	IChatBaseComponent addSibling(IChatBaseComponent var1);

	String getText();

	String c();

	List<IChatBaseComponent> a();

	IChatBaseComponent f();

	public static class ChatSerializer implements JsonDeserializer<IChatBaseComponent>, JsonSerializer<IChatBaseComponent> {

		private static final Gson gson = new GsonBuilder()
		.registerTypeHierarchyAdapter(IChatBaseComponent.class, new IChatBaseComponent.ChatSerializer())
		.registerTypeHierarchyAdapter(ChatModifier.class, new ChatModifier.ChatModifierSerializer())
		.registerTypeAdapterFactory(new ChatTypeAdapterFactory())
		.create();

		@Override
		public IChatBaseComponent deserialize(JsonElement element, Type type, JsonDeserializationContext ctx) throws JsonParseException {
			if (element.isJsonPrimitive()) {
				return new ChatComponentText(element.getAsString());
			} else if (!element.isJsonObject()) {
				if (element.isJsonArray()) {
					JsonArray jsonArray = element.getAsJsonArray();
					IChatBaseComponent chatcomp = null;
					for (JsonElement jsonElement : jsonArray) {
						IChatBaseComponent innerchatcomp = deserialize(jsonElement, jsonElement.getClass(), ctx);
						if (chatcomp == null) {
							chatcomp = innerchatcomp;
						} else {
							chatcomp.addSibling(innerchatcomp);
						}
					}
					return chatcomp;
				} else {
					throw new JsonParseException("Don\'t know how to turn " + element.toString() + " into a Component");
				}
			} else {
				JsonObject jsonobject = element.getAsJsonObject();
				IChatBaseComponent resultComp;
				if (jsonobject.has("text")) {
					resultComp = new ChatComponentText(jsonobject.get("text").getAsString());
				} else if (jsonobject.has("translate")) {
					String translate = jsonobject.get("translate").getAsString();
					if (jsonobject.has("with")) {
						JsonArray withJsonArray = jsonobject.getAsJsonArray("with");
						Object[] array = new Object[withJsonArray.size()];

						for (int i = 0; i < array.length; ++i) {
							array[i] = deserialize(withJsonArray.get(i), type, ctx);
							if (array[i] instanceof ChatComponentText) {
								ChatComponentText compText = (ChatComponentText) array[i];
								if (compText.getChatModifier().g() && compText.a().isEmpty()) {
									array[i] = compText.g();
								}
							}
						}

						resultComp = new ChatMessage(translate, array);
					} else {
						resultComp = new ChatMessage(translate);
					}
				} else if (jsonobject.has("score")) {
					JsonObject scoreJsonObject = jsonobject.getAsJsonObject("score");
					if (!scoreJsonObject.has("name") || !scoreJsonObject.has("objective")) {
						throw new JsonParseException("A score component needs a least a name and an objective");
					}

					resultComp = new ChatComponentScore(JsonHelper.getString(scoreJsonObject, "name"), JsonHelper.getString(scoreJsonObject, "objective"));
					if (scoreJsonObject.has("value")) {
						((ChatComponentScore) resultComp).b(JsonHelper.getString(scoreJsonObject, "value"));
					}
				} else {
					if (!jsonobject.has("selector")) {
						throw new JsonParseException("Don\'t know how to turn " + element.toString() + " into a Component");
					}

					resultComp = new ChatComponentSelector(JsonHelper.getString(jsonobject, "selector"));
				}

				if (jsonobject.has("extra")) {
					JsonArray entryJsonArray = jsonobject.getAsJsonArray("extra");
					if (entryJsonArray.size() <= 0) {
						throw new JsonParseException("Unexpected empty array of components");
					}
					for (int i = 0; i < entryJsonArray.size(); ++i) {
						resultComp.addSibling(deserialize(entryJsonArray.get(i), type, ctx));
					}
				}

				resultComp.setChatModifier((ChatModifier) ctx.deserialize(element, ChatModifier.class));
				return resultComp;
			}
		}

		private void a(ChatModifier chatmodifier, JsonObject jsonobject, JsonSerializationContext ctx) {
			JsonElement element = ctx.serialize(chatmodifier);
			if (element.isJsonObject()) {
				JsonObject objelement = (JsonObject) element;
				for (Entry<String, JsonElement> entry : objelement.entrySet()) {
					jsonobject.add(entry.getKey(), entry.getValue());
				}
			}
		}

		@Override
		public JsonElement serialize(IChatBaseComponent base, Type type, JsonSerializationContext ctx) {
			JsonObject result = new JsonObject();
			if (!base.getChatModifier().g()) {
				this.a(base.getChatModifier(), result, ctx);
			}

			if (!base.a().isEmpty()) {
				JsonArray extrajson = new JsonArray();
				for (IChatBaseComponent comp : base.a()) {
					extrajson.add(serialize(comp, comp.getClass(), ctx));
				}
				result.add("extra", extrajson);
			}

			if (base instanceof ChatComponentText) {
				result.addProperty("text", ((ChatComponentText) base).g());
			} else if (base instanceof ChatMessage) {
				ChatMessage chatmessage = (ChatMessage) base;
				result.addProperty("translate", chatmessage.i());
				if ((chatmessage.j() != null) && (chatmessage.j().length > 0)) {
					JsonArray withjson = new JsonArray();
					for (Object arg : chatmessage.j()) {
						if (arg instanceof IChatBaseComponent) {
							withjson.add(serialize(((IChatBaseComponent) arg), arg.getClass(), ctx));
						} else {
							withjson.add(new JsonPrimitive(String.valueOf(arg)));
						}
					}

					result.add("with", withjson);
				}
			} else if (base instanceof ChatComponentScore) {
				ChatComponentScore scorecomp = (ChatComponentScore) base;
				JsonObject scorejson = new JsonObject();
				scorejson.addProperty("name", scorecomp.g());
				scorejson.addProperty("objective", scorecomp.h());
				scorejson.addProperty("value", scorecomp.getText());
				result.add("score", scorejson);
			} else {
				if (!(base instanceof ChatComponentSelector)) {
					throw new IllegalArgumentException("Don\'t know how to serialize " + base + " as a Component");
				}

				ChatComponentSelector selectorcomp = (ChatComponentSelector) base;
				result.addProperty("selector", selectorcomp.g());
			}

			return result;
		}

		public static String toJson(IChatBaseComponent var0) {
			return gson.toJson(var0);
		}

		public static IChatBaseComponent fromJson(String var0) {
			return JsonHelper.fromJson(gson, var0, IChatBaseComponent.class, true);
		}

		public static IChatBaseComponent b(final String var0) {
			return JsonHelper.fromJson(gson, var0, IChatBaseComponent.class, true);
		}

	}

}
