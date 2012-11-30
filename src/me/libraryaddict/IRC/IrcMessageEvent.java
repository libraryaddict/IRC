package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcMessageEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String message;
  private String nick;
  private String channel;
  private String botName;
  
  public IrcMessageEvent(String name, String msg, String chan, String bName) {
    message = msg;
    nick = name;
    channel = chan;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public String getMessage() {
    return message;
  }
  
  public String getChannel() {
    return channel;
  }
  
  public String getNick() {
    return nick;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
