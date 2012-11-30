package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcInviteEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String nick;
  private String channel;
  private String botName;
  
  public IrcInviteEvent(String name, String chan, String bName) {
    nick = name;
    channel = chan;
    botName = bName;
  }
  
  public String getChannel() {
    return channel;
  }
  
  public String getNick() {
    return nick;
  }
  
  public String getBot() {
    return botName;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
