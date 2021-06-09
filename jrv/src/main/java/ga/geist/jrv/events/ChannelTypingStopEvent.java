package ga.geist.jrv.events;

import ga.geist.jrv.types.Channel;
import ga.geist.jrv.types.User;

/**
 * Channel Typing Stop Event — Fired when someone stops typing in a channel
 */
public class ChannelTypingStopEvent extends Event {
    private Channel channel;
    private User user;

    /**
     * Retrieve the channel where the event occured.
     * 
     * @return The channel
     */
    public Channel getChannel() {
        return channel;
    }

    /**
     * Retrieve the user where the event occured.
     * 
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * Construct a channel typing stop event
     * 
     * @param channel The channel in which the event occured
     * @param user    The user that stopped typing
     */
    public ChannelTypingStopEvent(Channel channel, User user) {
        this.channel = channel;
        this.user = user;
    }
}
