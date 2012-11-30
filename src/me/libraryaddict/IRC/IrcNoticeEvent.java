package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcNoticeEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String msg;
  private String nick;
  private String channel;
  private String botName;
  
  public IrcNoticeEvent(String name, String target, String message, String bName) {
    nick = name;
    channel = target;
    msg = message;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public String getMessage() {
    return msg;
  }
  
  public String getNick() {
    return nick;
  }
  
  public String getTarget() {
    return channel;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
