/* 
Copyright Paul James Mutton, 2001-2009, http://www.jibble.org/

This file is part of PircBot.

This software is dual-licensed, allowing you to choose between the GNU
General Public License (GPL) and the www.jibble.org Commercial License.
Since the GPL may be too restrictive for use in a proprietary application,
a commercial license is also provided. Full license information can be
found at http://www.jibble.org/licenses/

 */

package org.jibble.pircbot;

/**
 * This class is used to represent a user on an IRC server. Instances of this
 * class are returned by the getUsers method in the PircBot class.
 * <p>
 * Note that this class no longer implements the Comparable interface for Java
 * 1.1 compatibility reasons.
 * 
 * @since 1.0.0
 * @author Paul James Mutton, <a
 *         href="http://www.jibble.org/">http://www.jibble.org/</a>
 * @version 1.5.0 (Build time: Mon Dec 14 20:07:17 2009)
 */
public class User {

  /**
   * Constructs a User object with a known prefix and nick.
   * 
   * @param prefix
   *          The status of the user, for example, "@".
   * @param nick
   *          The nick of the user.
   */
  User(String prefix, String nick) {
    _prefix = prefix;
    _nick = nick;
    _lowerNick = nick.toLowerCase();
  }

  /**
   * Returns the prefix of the user. If the User object has been obtained from a
   * list of users in a channel, then this will reflect the user's status in
   * that channel.
   * 
   * @return The prefix of the user. If there is no prefix, then an empty String
   *         is returned.
   */
  public String getPrefix() {
    return _prefix;
  }

  /**
   * Returns whether or not the user represented by this object is an operator.
   * If the User object has been obtained from a list of users in a channel,
   * then this will reflect the user's operator status in that channel.
   * 
   * <p>
   * This is @
   * 
   * 
   * @return true if the user is an operator in the channel.
   */
  public boolean hasOp() {
    return _prefix.indexOf('@') >= 0;
  }

  /**
   * Returns the rank of the user inside the channel. This uses from 0 meaning
   * no rank to 5 meaning owner.
   * <p>
   * This does not support unknown prefixes
   * <p>
   * Owner = 5, Admin/Protected = 4, Op = 3, Halfop = 2, Voice = 1, No Rank = 0
   * 
   * @return Rank of the user in the channel.
   */
  public Integer getRank() {
    if (hasOwner())
      return 5;
    else if (hasAdmin())
      return 4;
    else if (hasOp())
      return 3;
    else if (hasHalfop())
      return 2;
    else if (hasVoice())
      return 1;
    return 0;
  }

  /**
   * Returns whether or not the user represented by this object has voice. If
   * the User object has been obtained from a list of users in a channel, then
   * this will reflect the user's voice status in that channel.
   * <p>
   * This is +
   * 
   * 
   * @return true if the user has voice in the channel.
   */
  public boolean hasVoice() {
    return _prefix.indexOf('+') >= 0;
  }

  /**
   * Returns whether or not the user represented by this object has admin. If
   * the User object has been obtained from a list of users in a channel, then
   * this will reflect the user's admin status in that channel.
   * <p>
   * This is ~
   * 
   * 
   * @return true if the user has admin in the channel.
   */
  public boolean hasOwner() {
    return _prefix.indexOf('~') >= 0;
  }

  /**
   * Returns whether or not the user represented by this object has halfop. If
   * the User object has been obtained from a list of users in a channel, then
   * this will reflect the user's halfop status in that channel. *
   * <p>
   * This is %
   * 
   * @return true if the user has halfop in the channel.
   */
  public boolean hasHalfop() {
    return _prefix.indexOf('%') >= 0;
  }

  /**
   * Returns whether or not the user represented by this object has protected.
   * If the User object has been obtained from a list of users in a channel,
   * then this will reflect the user's protected status in that channel.
   * <p>
   * This is &
   * 
   * @return true if the user has protected in the channel.
   */
  public boolean hasProtected() {
    return _prefix.indexOf('&') >= 0;
  }

  /**
   * Returns whether or not the user represented by this object has protected.
   * If the User object has been obtained from a list of users in a channel,
   * then this will reflect the user's admin status in that channel.
   * <p>
   * This is &
   * 
   * @return true if the user has admin in the channel.
   */
  public boolean hasAdmin() {
    return _prefix.indexOf('&') >= 0;
  }

  /**
   * Returns the nick of the user.
   * 
   * @return The user's nick.
   */
  public String getNick() {
    return _nick;
  }

  /**
   * Returns the nick of the user complete with their prefix if they have one,
   * e.g. "@Dave".
   * 
   * @return The user's prefix and nick.
   */
  public String toString() {
    return this.getPrefix() + this.getNick();
  }

  /**
   * Returns true if the nick represented by this User object is the same as the
   * argument. A case insensitive comparison is made.
   * 
   * @return true if the nicks are identical (case insensitive).
   */
  public boolean equals(String nick) {
    return nick.toLowerCase().equals(_lowerNick);
  }

  /**
   * Returns true if the nick represented by this User object is the same as the
   * nick of the User object given as an argument. A case insensitive comparison
   * is made.
   * 
   * @return true if o is a User object with a matching lowercase nick.
   */
  public boolean equals(Object o) {
    if (o instanceof User) {
      User other = (User) o;
      return other._lowerNick.equals(_lowerNick);
    }
    return false;
  }

  /**
   * Returns the hash code of this User object.
   * 
   * @return the hash code of the User object.
   */
  public int hashCode() {
    return _lowerNick.hashCode();
  }

  /**
   * Returns the result of calling the compareTo method on lowercased nicks.
   * This is useful for sorting lists of User objects.
   * 
   * @return the result of calling compareTo on lowercased nicks.
   */
  public int compareTo(Object o) {
    if (o instanceof User) {
      User other = (User) o;
      return other._lowerNick.compareTo(_lowerNick);
    }
    return -1;
  }

  private String _prefix;
  private String _nick;
  private String _lowerNick;

}
