package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcQuitEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String nick;
  private String reason;
  private String botName;
  
  public IrcQuitEvent(String name, String why, String bName) {
    nick = name;
    reason = why;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public String getNick() {
    return nick;
  }
  
  
  public String getReason() {
    return reason;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
