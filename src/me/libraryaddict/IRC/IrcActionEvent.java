package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcActionEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String nick;
  private String target;
  private String action;
  private String botName;
  
  public IrcActionEvent(String name, String who, String act, String bName) {
    action = act;
    nick = name;
    target = who;
    botName = bName;
  }
  
  public String getNick() {
    return nick;
  }
  
  public String getAction() {
    return action;
  }
  
  public String getTarget() {
    return target;
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
