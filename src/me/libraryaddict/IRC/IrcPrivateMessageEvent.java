package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcPrivateMessageEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String nick;
  private String msg;
  private String botName;
  
  public IrcPrivateMessageEvent(String name, String message, String bName) {
    nick = name;
    msg = message;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public String getNick() {
    return nick;
  }
  
  public String getMessage() {
    return msg;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
