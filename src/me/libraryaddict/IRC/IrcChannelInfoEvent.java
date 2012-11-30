package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcChannelInfoEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String channel;
  private int userCount;
  private String topic;
  private String botName;
  
  public IrcChannelInfoEvent(String chan, int users, String top, String bName) {
   channel = chan;
   userCount = users;
   topic = top;
   botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public String getTopic() {
    return topic;
  }
  
  public String getChannel() {
    return channel;
  }
  
  public int getUserCount() {
    return userCount;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
