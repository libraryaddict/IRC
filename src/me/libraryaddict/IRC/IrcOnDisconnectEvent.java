package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcOnDisconnectEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String botName;
  
  public IrcOnDisconnectEvent(String bName) {
    botName = bName;
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
