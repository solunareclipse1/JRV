package ga.geist.jrv.types;

import org.json.JSONObject;

import ga.geist.jrv.RevoltBridge;

/**
 * Message class
 */
public class Message {
    private User author;
    private Channel channel;
    private String id;
    private String nonce;
    private String content;
    private Attachment attachment;

    /**
     * Get the author of the message
     * 
     * @return The author of the message
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Get the channel the message was posted to
     * 
     * @return The channel the message was posted to
     */
    public Channel getChannel() {
        return channel;
    }

    /**
     * Get the content of the message
     * 
     * @return The content of the message
     */
    public String getContent() {
        return content;
    }

    /**
     * Get the ID of the message
     * 
     * @return The ID of the message
     */
    public String getId() {
        return id;
    }

    /**
     * Get the nonce of the message
     * 
     * @return The nonce of the message
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * Get the attachment of the message
     * 
     * @return The attachment of the message. <strong>May be null.</strong>
     */
    public Attachment getAttachment() {
        return attachment;
    }

    /**
     * Construct a message
     * 
     * @param author     Message author
     * @param channel    Message channel
     * @param id         Message ID
     * @param nonce      Message nonce
     * @param content    Message content
     * @param attachment Message attachment
     */
    public Message(User author, Channel channel, String id, String nonce, String content, Attachment attachment) {
        this.author = author;
        this.channel = channel;
        this.id = id;
        this.nonce = nonce;
        this.content = content;
        this.attachment = attachment;
    }

    /**
     * Construct a message from JSON
     * 
     * @param object Message object
     * @param bridge Revolt bridge
     * @return Message class instance
     */
    public static Message fromJSON(JSONObject object, RevoltBridge bridge) {
        return new Message(bridge.getRegistries().getUserRegistry().get(object.getString("author")),
                bridge.getRegistries().getChannelRegistry().get(object.getString("channel")), object.getString("_id"),
                object.optString("nonce"), object.optString("content"),
                Attachment.fromJSON(object.optJSONObject("attachment")));
    }
}
