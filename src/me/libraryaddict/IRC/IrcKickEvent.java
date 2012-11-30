package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcKickEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String kicked;
  private String kicker;
  private String reason;
  private String channel;
  private String botName;
  
  public IrcKickEvent(String kiked, String kiker, String why, String chan, String bName) {
    kicked = kiked;
    kicker = kiker;
    reason = why;
    channel = chan;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public String getKicker() {
    return kicker;
  }
  
  public String getKicked() {
    return kicked;
  }
  
  public String getReason() {
    return reason;
  }
  
  public String getChannel() {
    return channel;
  }
  

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
