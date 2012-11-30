package me.libraryaddict.IRC;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;

import org.jibble.pircbot.DccChat;
import org.jibble.pircbot.DccFileTransfer;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.User;

public interface Interface {

	/**
	 * The definitive version number of this release of PircBot. (Note: Change
	 * this before automatically building releases)
	 */
	public static final String VERSION = "1.5.0";
	static String[] MC = new String[22];
	static String[] IRC = new String[22];

	/**
	 * Constructs a PircBot with the default settings. Your own constructors in
	 * classes which extend the PircBot abstract class should be responsible for
	 * changing the default settings if required.
	 */

	/**
	 * Attempt to connect to the specified IRC server. The onConnect method is
	 * called upon success.
	 * 
	 * @param hostname
	 *            The hostname of the server to connect to.
	 * 
	 * @throws IOException
	 *             if it was not possible to connect to the server.
	 * @throws IrcException
	 *             if the server would not let us join it.
	 * @throws NickAlreadyInUseException
	 *             if our nick is already in use on the server.
	 */
	public void connect(String hostname) throws IOException, IrcException,
			NickAlreadyInUseException;

	/**
	 * Enables message output delay
	 */
	public void enableDelay();

	/**
	 * Disables message output delay
	 */
	public void disableDelay();

	/**
	 * Returns if delay is enabled
	 */
	public boolean isDelay();

	/**
	 * Attempt to connect to the specified IRC server and port number. The
	 * onConnect method is called upon success.
	 * 
	 * @param hostname
	 *            The hostname of the server to connect to.
	 * @param port
	 *            The port number to connect to on the server.
	 * 
	 * @throws IOException
	 *             if it was not possible to connect to the server.
	 * @throws IrcException
	 *             if the server would not let us join it.
	 * @throws NickAlreadyInUseException
	 *             if our nick is already in use on the server.
	 */
	public void connect(String hostname, int port) throws IOException,
			IrcException, NickAlreadyInUseException;

	/**
	 * Attempt to connect to the specified IRC server using the supplied
	 * password. The onConnect method is called upon success.
	 * 
	 * @param hostname
	 *            The hostname of the server to connect to.
	 * @param port
	 *            The port number to connect to on the server.
	 * @param password
	 *            The password to use to join the server.
	 * 
	 * @throws IOException
	 *             if it was not possible to connect to the server.
	 * @throws IrcException
	 *             if the server would not let us join it.
	 * @throws NickAlreadyInUseException
	 *             if our nick is already in use on the server.
	 */
	public void connect(String hostname, int port, String password)
			throws IOException, IrcException, NickAlreadyInUseException;

	/**
	 * Reconnects to the IRC server that we were previously connected to. If
	 * necessary, the appropriate port number and password will be used. This
	 * method will throw an IrcException if we have never connected to an IRC
	 * server previously.
	 * 
	 * @since PircBot 0.9.9
	 * 
	 * @throws IOException
	 *             if it was not possible to connect to the server.
	 * @throws IrcException
	 *             if the server would not let us join it.
	 * @throws NickAlreadyInUseException
	 *             if our nick is already in use on the server.
	 */
	public void reconnect() throws IOException, IrcException,
			NickAlreadyInUseException;

	/**
	 * This method disconnects from the server cleanly by calling the
	 * quitServer() method. Providing the PircBot was connected to an IRC
	 * server, the onDisconnect() will be called as soon as the disconnection is
	 * made by the server.
	 * 
	 * @see #quitServer() quitServer
	 * @see #quitServer(String) quitServer
	 */
	public void disconnect();

	/**
	 * When you connect to a server and your nick is already in use and this is
	 * set to true, a new nick will be automatically chosen. This is done by
	 * adding numbers to the end of the nick until an available nick is found.
	 * 
	 * @param autoNickChange
	 *            Set to true if you want automatic nick changes during
	 *            connection.
	 */
	public void setAutoNickChange(boolean autoNickChange);

	/**
	 * Starts an ident server (Identification Protocol Server, RFC 1413).
	 * <p>
	 * Most IRC servers attempt to contact the ident server on connecting hosts
	 * in order to determine the user's identity. A few IRC servers will not
	 * allow you to connect unless this information is provided.
	 * <p>
	 * So when a PircBot is run on a machine that does not run an ident server,
	 * it may be necessary to call this method to start one up.
	 * <p>
	 * Calling this method starts up an ident server which will respond with the
	 * login provided by calling getLogin() and then shut down immediately. It
	 * will also be shut down if it has not been contacted within 60 seconds of
	 * creation.
	 * <p>
	 * If you require an ident response, then the correct procedure is to start
	 * the ident server and then connect to the IRC server. The IRC server may
	 * then contact the ident server to get the information it needs.
	 * <p>
	 * The ident server will fail to start if there is already an ident server
	 * running on port 113, or if you are running as an unprivileged user who is
	 * unable to create a server socket on that port number.
	 * <p>
	 * If it is essential for you to use an ident server when connecting to an
	 * IRC server, then make sure that port 113 on your machine is visible to
	 * the IRC server so that it may contact the ident server.
	 * 
	 * @since PircBot 0.9c
	 */
	public void startIdentServer();

	/**
	 * Joins a channel.
	 * 
	 * @param channel
	 *            The name of the channel to join (eg "#cs").
	 */
	public void joinChannel(String channel);

	/**
	 * Joins a channel with a key.
	 * 
	 * @param channel
	 *            The name of the channel to join (eg "#cs").
	 * @param key
	 *            The key that will be used to join the channel.
	 */
	public void joinChannel(String channel, String key);

	/**
	 * Parts a channel.
	 * 
	 * @param channel
	 *            The name of the channel to leave.
	 */
	public void partChannel(String channel);

	/**
	 * Parts a channel, giving a reason.
	 * 
	 * @param channel
	 *            The name of the channel to leave.
	 * @param reason
	 *            The reason for parting the channel.
	 */
	public void partChannel(String channel, String reason);

	/**
	 * Quits from the IRC server. Providing we are actually connected to an IRC
	 * server, the onDisconnect() method will be called as soon as the IRC
	 * server disconnects us.
	 */
	public void quitServer();

	/**
	 * Quits from the IRC server with a reason. Providing we are actually
	 * connected to an IRC server, the onDisconnect() method will be called as
	 * soon as the IRC server disconnects us.
	 * 
	 * @param reason
	 *            The reason for quitting the server.
	 */
	public void quitServer(String reason);

	/**
	 * Sends a raw line to the IRC server as soon as possible, bypassing the
	 * outgoing message queue.
	 * 
	 * @param line
	 *            The raw line to send to the IRC server.
	 * @param number
	 *            The number that will be in IrcSentEvent when it has been sent
	 */
	public void sendRawLine(String line);

	/**
	 * Sends a raw line through the outgoing message queue.
	 * 
	 * @param line
	 *            The raw line to send to the IRC server.
	 */
	public void sendRawLineViaQueue(String line);

	/**
	 * Sends a message to a channel or a private message to a user. These
	 * messages are added to the outgoing message queue and sent at the earliest
	 * possible opportunity.
	 * <p>
	 * Some examples: -
	 * 
	 * <pre>
	 * // Send the message &quot;Hello!&quot; to the channel #cs.
	 * sendMessage(&quot;#cs&quot;, &quot;Hello!&quot;);
	 * 
	 * // Send a private message to Paul that says &quot;Hi&quot;.
	 * sendMessage(&quot;Paul&quot;, &quot;Hi&quot;);
	 * </pre>
	 * 
	 * You may optionally apply colours, boldness, underlining, etc to the
	 * message by using the <code>Colors</code> class.
	 * 
	 * @param target
	 *            The name of the channel or user nick to send to.
	 * @param message
	 *            The message to send.
	 * @return 
	 * 
	 * @see Colors
	 */
	public void sendMessage(String target, String message);

	/**
	 * Sends an action to the channel or to a user.
	 * 
	 * @param target
	 *            The name of the channel or user nick to send to.
	 * @param action
	 *            The action to send.
	 * @return 
	 * 
	 * @see Colors
	 */
	public void sendAction(String target, String action);

	/**
	 * Sends a notice to the channel or to a user.
	 * 
	 * @param target
	 *            The name of the channel or user nick to send to.
	 * @param notice
	 *            The notice to send.
	 * @return 
	 */
	public void sendNotice(String target, String notice);

	/**
	 * Sends a CTCP command to a channel or user. (Client to client protocol).
	 * Examples of such commands are "PING <number>", "FINGER", "VERSION", etc.
	 * For example, if you wish to request the version of a user called "Dave",
	 * then you would call <code>sendCTCPCommand("Dave", "VERSION");</code>. The
	 * type of response to such commands is largely dependant on the target
	 * client software.
	 * 
	 * @since PircBot 0.9.5
	 * 
	 * @param target
	 *            The name of the channel or user to send the CTCP message to.
	 * @param command
	 *            The CTCP command to send.
	 * @param number
	 *            The number which will return on IrcSentEvent
	 */
	public void sendCTCPCommand(String target, String command);

	/**
	 * Attempt to change the current nick (nickname) of the bot when it is
	 * connected to an IRC server. After confirmation of a successful nick
	 * change, the getNick method will return the new nick.
	 * 
	 * @param newNick
	 *            The new nick to use.
	 */
	public void changeNick(String newNick);

	/**
	 * Identify the bot with NickServ, supplying the appropriate password. Some
	 * IRC Networks (such as freenode) require users to <i>register</i> and
	 * <i>identify</i> with NickServ before they are able to send private
	 * messages to other users, thus reducing the amount of spam. If you are
	 * using an IRC network where this kind of policy is enforced, you will need
	 * to make your bot <i>identify</i> itself to NickServ before you can send
	 * private messages. Assuming you have already registered your bot's nick
	 * with NickServ, this method can be used to <i>identify</i> with the
	 * supplied password. It usually makes sense to identify with NickServ
	 * immediately after connecting to a server.
	 * <p>
	 * This method issues a raw NICKSERV command to the server, and is therefore
	 * safer than the alternative approach of sending a private message to
	 * NickServ. The latter approach is considered dangerous, as it may cause
	 * you to inadvertently transmit your password to an untrusted party if you
	 * connect to a network which does not run a NickServ service and where the
	 * untrusted party has assumed the nick "NickServ". However, if your IRC
	 * network is only compatible with the private message approach, you may
	 * typically identify like so:
	 * 
	 * <pre>
	 * sendMessage(&quot;NickServ&quot;, &quot;identify PASSWORD&quot;);
	 * </pre>
	 * 
	 * @param password
	 *            The password which will be used to identify with NickServ.
	 */
	public void identify(String password);

	/**
	 * Set the mode of a channel. This method attempts to set the mode of a
	 * channel. This may require the bot to have operator status on the channel.
	 * For example, if the bot has operator status, we can grant operator status
	 * to "Dave" on the #cs channel by calling setMode("#cs", "+o Dave"); An
	 * alternative way of doing this would be to use the op method.
	 * 
	 * @param channel
	 *            The channel on which to perform the mode change.
	 * @param mode
	 *            The new mode to apply to the channel. This may include zero or
	 *            more arguments if necessary.
	 * 
	 * @see #op(String,String) op
	 */
	public void setMode(String channel, String mode);
	/**
	 * Sends an invitation to join a channel. Some channels can be marked as
	 * "invite-only", so it may be useful to allow a bot to invite people into
	 * it.
	 * 
	 * @param nick
	 *            The nick of the user to invite
	 * @param channel
	 *            The channel you are inviting the user to join.
	 * 
	 */
	public void sendInvite(String nick, String channel);
	/**
	 * Bans a user from a channel. An example of a valid hostmask is
	 * "*!*compu@*.18hp.net". This may be used in conjunction with the kick
	 * method to permanently remove a user from a channel. Successful use of
	 * this method may require the bot to have operator status itself.
	 * 
	 * @param channel
	 *            The channel to ban the user from.
	 * @param hostmask
	 *            A hostmask representing the user we're banning.
	 */
	public void ban(String channel, String hostmask);

	/**
	 * Unbans a user from a channel. An example of a valid hostmask is
	 * "*!*compu@*.18hp.net". Successful use of this method may require the bot
	 * to have operator status itself.
	 * 
	 * @param channel
	 *            The channel to unban the user from.
	 * @param hostmask
	 *            A hostmask representing the user we're unbanning.
	 */
	public void unBan(String channel, String hostmask);
	/**
	 * Returns the prefix from a user in a channel. This reflects their status
	 * as a admin, operator etc. You can alternately get the user and check for
	 * their status from there.
	 * 
	 * @param channel
	 *            Channel you want to grab their prefix from
	 * @param nick
	 *            Nick of the user you want to get it from
	 * @return Prefix
	 */
	public String getPrefix(String channel, String nick);

	/**
	 * Grants operator privilidges to a user on a channel. Successful use of
	 * this method may require the bot to have operator status itself.
	 * 
	 * @param channel
	 *            The channel we're opping the user on.
	 * @param nick
	 *            The nick of the user we are opping.
	 */
	public void op(String channel, String nick);

	/**
	 * Removes operator privilidges from a user on a channel. Successful use of
	 * this method may require the bot to have operator status itself.
	 * 
	 * @param channel
	 *            The channel we're deopping the user on.
	 * @param nick
	 *            The nick of the user we are deopping.
	 */
	public void deOp(String channel, String nick);

	/**
	 * Grants voice privileges to a user on a channel. Successful use of this
	 * method may require the bot to have operator status itself.
	 * 
	 * @param channel
	 *            The channel we're voicing the user on.
	 * @param nick
	 *            The nick of the user we are voicing.
	 */
	public void voice(String channel, String nick);

	/**
	 * Removes voice privilidges from a user on a channel. Successful use of
	 * this method may require the bot to have operator status itself.
	 * 
	 * @param channel
	 *            The channel we're devoicing the user on.
	 * @param nick
	 *            The nick of the user we are devoicing.
	 */
	public void deVoice(String channel, String nick);

	/**
	 * Set the topic for a channel. This method attempts to set the topic of a
	 * channel. This may require the bot to have operator status if the topic is
	 * protected.
	 * 
	 * @param channel
	 *            The channel on which to perform the mode change.
	 * @param topic
	 *            The new topic for the channel.
	 * 
	 */
	public void setTopic(String channel, String topic);
	/**
	 * Kicks a user from a channel. This method attempts to kick a user from a
	 * channel and may require the bot to have operator status in the channel.
	 * 
	 * @param channel
	 *            The channel to kick the user from.
	 * @param nick
	 *            The nick of the user to kick.
	 */
	public void kick(String channel, String nick);

	/**
	 * Kicks a user from a channel, giving a reason. This method attempts to
	 * kick a user from a channel and may require the bot to have operator
	 * status in the channel.
	 * 
	 * @param channel
	 *            The channel to kick the user from.
	 * @param nick
	 *            The nick of the user to kick.
	 * @param reason
	 *            A description of the reason for kicking a user.
	 */
	public void kick(String channel, String nick, String reason);

	/**
	 * Issues a request for a list of all channels on the IRC server. When the
	 * PircBot receives information for each channel, it will call the
	 * onChannelInfo method, which you will need to override if you want it to
	 * do anything useful.
	 * 
	 * @see #onChannelInfo(String,int,String) onChannelInfo
	 */
	public void listChannels();

	/**
	 * Issues a request for a list of all channels on the IRC server. When the
	 * PircBot receives information for each channel, it will call the
	 * onChannelInfo method, which you will need to override if you want it to
	 * do anything useful.
	 * <p>
	 * Some IRC servers support certain parameters for LIST requests. One
	 * example is a parameter of ">10" to list only those channels that have
	 * more than 10 users in them. Whether these parameters are supported or not
	 * will depend on the IRC server software.
	 * 
	 * @param parameters
	 *            The parameters to supply when requesting the list.
	 * 
	 * @see #onChannelInfo(String,int,String) onChannelInfo
	 */
	public void listChannels(String parameters);

	/**
	 * Sends a file to another user. Resuming is supported. The other user must
	 * be able to connect directly to your bot to be able to receive the file.
	 * <p>
	 * You may throttle the speed of this file transfer by calling the
	 * setPacketDelay method on the DccFileTransfer that is returned.
	 * <p>
	 * This method may not be overridden.
	 * 
	 * @since 0.9c
	 * 
	 * @param file
	 *            The file to send.
	 * @param nick
	 *            The user to whom the file is to be sent.
	 * @param timeout
	 *            The number of milliseconds to wait for the recipient to
	 *            acccept the file (we recommend about 120000).
	 * 
	 * @return The DccFileTransfer that can be used to monitor this transfer.
	 * 
	 * @see DccFileTransfer
	 * 
	 */
	public DccFileTransfer dccSendFile(File file, String nick, int timeout);

	/**
	 * Attempts to establish a DCC CHAT session with a client. This method
	 * issues the connection request to the client and then waits for the client
	 * to respond. If the connection is successfully made, then a DccChat object
	 * is returned by this method. If the connection is not made within the time
	 * limit specified by the timeout value, then null is returned.
	 * <p>
	 * It is <b>strongly recommended</b> that you call this method within a new
	 * Thread, as it may take a long time to return.
	 * <p>
	 * This method may not be overridden.
	 * 
	 * @since PircBot 0.9.8
	 * 
	 * @param nick
	 *            The nick of the user we are trying to establish a chat with.
	 * @param timeout
	 *            The number of milliseconds to wait for the recipient to accept
	 *            the chat connection (we recommend about 120000).
	 * 
	 * @return a DccChat object that can be used to send and recieve lines of
	 *         text. Returns <b>null</b> if the connection could not be made.
	 * 
	 * @see DccChat
	 */
	public DccChat dccSendChatRequest(String nick, int timeout);

	/**
	 * Adds a line to the log. This log is currently output to the standard
	 * output and is in the correct format for use by tools such as pisg, the
	 * Perl IRC Statistics Generator. You may override this method if you wish
	 * to do something else with log entries. Each line in the log begins with a
	 * number which represents the logging time (as the number of milliseconds
	 * since the epoch). This timestamp and the following log entry are
	 * separated by a single space character, " ". Outgoing messages are
	 * distinguishable by a log entry that has ">>>" immediately following the
	 * space character after the timestamp. DCC events use "+++" and warnings
	 * about unhandled Exceptions and Errors use "###".
	 * <p>
	 * This implementation of the method will only cause log entries to be
	 * output if the PircBot has had its verbose mode turned on by calling
	 * setVerbose(true);
	 * 
	 * @param line
	 *            The line to add to the log.
	 */
	public void log(String line);

	/**
	 * Sets the verbose mode. If verbose mode is set to true, then log entries
	 * will be printed to the standard output. The default value is false and
	 * will result in no output. For general development, we strongly recommend
	 * setting the verbose mode to true.
	 * 
	 * @param verbose
	 *            true if verbose mode is to be used. Default is false.
	 */
	public void setVerbose(boolean verbose);

	/**
	 * Sets the name of the bot, which will be used as its nick when it tries to
	 * join an IRC server. This should be set before joining any servers,
	 * otherwise the default nick will be used. You would typically call this
	 * method from the constructor of the class that extends PircBot.
	 * <p>
	 * The changeNick method should be used if you wish to change your nick when
	 * you are connected to a server.
	 * 
	 * @param name
	 *            The new name of the Bot.
	 */
	public void setName(String name);

	/**
	 * Gets the name of the PircBot. This is the name that will be used as as a
	 * nick when we try to join servers.
	 * 
	 * @return The name of the PircBot.
	 */
	public String getName();

	/**
	 * Returns the current nick of the bot. Note that if you have just changed
	 * your nick, this method will still return the old nick until confirmation
	 * of the nick change is received from the server.
	 * <p>
	 * The nick returned by this method is maintained only by the PircBot class
	 * and is guaranteed to be correct in the context of the IRC server.
	 * 
	 * @since PircBot 1.0.0
	 * 
	 * @return The current nick of the bot.
	 */
	public String getNick();

	/**
	 * Gets the internal login of the PircBot.
	 * 
	 * @return The login of the PircBot.
	 */
	public String getLogin();

	/**
	 * Gets the internal version of the PircBot.
	 * 
	 * @return The version of the PircBot.
	 */
	public String getVersion();

	/**
	 * Gets the internal finger message of the PircBot.
	 * 
	 * @return The finger message of the PircBot.
	 */
	public String getFinger();

	/**
	 * Returns whether or not the PircBot is currently connected to a server.
	 * The result of this method should only act as a rough guide, as the result
	 * may not be valid by the time you act upon it.
	 * 
	 * @return True if and only if the PircBot is currently connected to a
	 *         server.
	 */
	public boolean isConnected();
	/**
	 * Sets the number of milliseconds to delay between consecutive messages
	 * when there are multiple messages waiting in the outgoing message queue.
	 * This has a default value of 1000ms. It is a good idea to stick to this
	 * default value, as it will prevent your bot from spamming servers and
	 * facing the subsequent wrath! However, if you do need to change this delay
	 * value (<b>not recommended</b>), then this is the method to use.
	 * 
	 * @param delay
	 *            The number of milliseconds between each outgoing message.
	 * 
	 */
	public void setMessageDelay(long delay);

	/**
	 * Returns the number of milliseconds that will be used to separate
	 * consecutive messages to the server from the outgoing message queue.
	 * 
	 * @return Number of milliseconds.
	 */
	public long getMessageDelay();

	/**
	 * Gets the maximum length of any line that is sent via the IRC protocol.
	 * The IRC RFC specifies that line lengths, including the trailing \r\n must
	 * not exceed 512 bytes. Hence, there is currently no option to change this
	 * value in PircBot. All lines greater than this length will be truncated
	 * before being sent to the IRC server.
	 * 
	 * @return The maximum line length (currently fixed at 512)
	 */
	public int getMaxLineLength();

	/**
	 * Gets the number of lines currently waiting in the outgoing message Queue.
	 * If this returns 0, then the Queue is empty and any new message is likely
	 * to be sent to the IRC server immediately.
	 * 
	 * @since PircBot 0.9.9
	 * 
	 * @return The number of lines in the outgoing message Queue.
	 */
	public int getOutgoingQueueSize();

	/**
	 * Returns the name of the last IRC server the PircBot tried to connect to.
	 * This does not imply that the connection attempt to the server was
	 * successful (we suggest you look at the onConnect method). A value of null
	 * is returned if the PircBot has never tried to connect to a server.
	 * 
	 * @return The name of the last machine we tried to connect to. Returns null
	 *         if no connection attempts have ever been made.
	 */
	public String getServer();

	/**
	 * Returns the port number of the last IRC server that the PircBot tried to
	 * connect to. This does not imply that the connection attempt to the server
	 * was successful (we suggest you look at the onConnect method). A value of
	 * -1 is returned if the PircBot has never tried to connect to a server.
	 * 
	 * @since PircBot 0.9.9
	 * 
	 * @return The port number of the last IRC server we connected to. Returns
	 *         -1 if no connection attempts have ever been made.
	 */
	public int getPort();

	/**
	 * Returns the last password that we used when connecting to an IRC server.
	 * This does not imply that the connection attempt to the server was
	 * successful (we suggest you look at the onConnect method). A value of null
	 * is returned if the PircBot has never tried to connect to a server using a
	 * password.
	 * 
	 * @since PircBot 0.9.9
	 * 
	 * @return The last password that we used when connecting to an IRC server.
	 *         Returns null if we have not previously connected using a
	 *         password.
	 */
	public String getPassword();
	/**
	 * A convenient method that accepts an IP address represented as a long and
	 * returns an integer array of size 4 representing the same IP address.
	 * 
	 * @since PircBot 0.9.4
	 * 
	 * @param address
	 *            the long value representing the IP address.
	 * 
	 * @return An int[] of size 4.
	 */
	public int[] longToIp(long address);

	/**
	 * A convenient method that accepts an IP address represented by a byte[] of
	 * size 4 and returns this as a long representation of the same IP address.
	 * 
	 * @since PircBot 0.9.4
	 * 
	 * @param address
	 *            the byte[] of size 4 representing the IP address.
	 * 
	 * @return a long representation of the IP address.
	 */
	public long ipToLong(byte[] address);

	/**
	 * Sets the encoding charset to be used when sending or receiving lines from
	 * the IRC server. If set to null, then the platform's default charset is
	 * used. You should only use this method if you are trying to send text to
	 * an IRC server in a different charset, e.g. "GB2312" for Chinese encoding.
	 * If a PircBot is currently connected to a server, then it must reconnect
	 * before this change takes effect.
	 * 
	 * @since PircBot 1.0.4
	 * 
	 * @param charset
	 *            The new encoding charset to be used by PircBot.
	 * 
	 * @throws UnsupportedEncodingException
	 *             If the named charset is not supported.
	 */
	public void setEncoding(String charset) throws UnsupportedEncodingException;

	/**
	 * Returns the encoding used to send and receive lines from the IRC server,
	 * or null if not set. Use the setEncoding method to change the encoding
	 * charset.
	 * 
	 * @since PircBot 1.0.4
	 * 
	 * @return The encoding used to send outgoing messages, or null if not set.
	 */
	public String getEncoding();

	/**
	 * Returns the InetAddress used by the PircBot. This can be used to find the
	 * I.P. address from which the PircBot is connected to a server.
	 * 
	 * @since PircBot 1.4.4
	 * 
	 * @return The current local InetAddress, or null if never connected.
	 */
	public InetAddress getInetAddress();

	/**
	 * Sets the InetAddress to be used when sending DCC chat or file transfers.
	 * This can be very useful when you are running a bot on a machine which is
	 * behind a firewall and you need to tell receiving clients to connect to a
	 * NAT/router, which then forwards the connection.
	 * 
	 * @since PircBot 1.4.4
	 * 
	 * @param dccInetAddress
	 *            The new InetAddress, or null to use the default.
	 */
	public void setDccInetAddress(InetAddress dccInetAddress);

	/**
	 * Returns the InetAddress used when sending DCC chat or file transfers. If
	 * this is null, the default InetAddress will be used.
	 * 
	 * @since PircBot 1.4.4
	 * 
	 * @return The current DCC InetAddress, or null if left as default.
	 */
	public InetAddress getDccInetAddress();

	/**
	 * Returns the set of port numbers to be used when sending a DCC chat or
	 * file transfer. This is useful when you are behind a firewall and need to
	 * set up port forwarding. The array of port numbers is traversed in
	 * sequence until a free port is found to listen on. A DCC tranfer will fail
	 * if all ports are already in use. If set to null, <i>any</i> free port
	 * number will be used.
	 * 
	 * @since PircBot 1.4.4
	 * 
	 * @return An array of port numbers that PircBot can use to send DCC
	 *         transfers, or null if any port is allowed.
	 */
	public int[] getDccPorts();

	/**
	 * Sets the choice of port numbers that can be used when sending a DCC chat
	 * or file transfer. This is useful when you are behind a firewall and need
	 * to set up port forwarding. The array of port numbers is traversed in
	 * sequence until a free port is found to listen on. A DCC tranfer will fail
	 * if all ports are already in use. If set to null, <i>any</i> free port
	 * number will be used.
	 * 
	 * @since PircBot 1.4.4
	 * 
	 * @param ports
	 *            The set of port numbers that PircBot may use for DCC
	 *            transfers, or null to let it use any free port (default).
	 * 
	 */
	public void setDccPorts(int[] ports);

	/**
	 * Returns true if and only if the object being compared is the exact same
	 * instance as this PircBot. This may be useful if you are writing a
	 * multiple server IRC bot that uses more than one instance of PircBot.
	 * 
	 * @since PircBot 0.9.9
	 * 
	 * @return true if and only if Object o is a PircBot and equal to this.
	 */
	public boolean equals(Object o);

	/**
	 * Returns the hashCode of this PircBot. This method can be called by hashed
	 * collection classes and is useful for managing multiple instances of
	 * PircBots in such collections.
	 * 
	 * @since PircBot 0.9.9
	 * 
	 * @return the hash code for this instance of PircBot.
	 */
	public int hashCode();

	/**
	 * Returns a String representation of this object. You may find this useful
	 * for debugging purposes, particularly if you are using more than one
	 * PircBot instance to achieve multiple server connectivity. The format of
	 * this String may change between different versions of PircBot but is
	 * currently something of the form <code>
	 *   Version{PircBot x.y.z Java IRC Bot - www.jibble.org}
	 *   Connected{true}
	 *   Server{irc.dal.net}
	 *   Port{6667}
	 *   Password{}
	 * </code>
	 * 
	 * @since PircBot 0.9.10
	 * 
	 * @return a String representation of this object.
	 */
	public String toString();

	/**
	 * Returns an array of all users in the specified channel.
	 * <p>
	 * There are some important things to note about this method:-
	 * <ul>
	 * <li>This method may not return a full list of users if you call it before
	 * the complete nick list has arrived from the IRC server.</li>
	 * <li>If you wish to find out which users are in a channel as soon as you
	 * join it, then you should override the onUserList method instead of
	 * calling this method, as the onUserList method is only called as soon as
	 * the full user list has been received.</li>
	 * <li>This method will return immediately, as it does not require any
	 * interaction with the IRC server.</li>
	 * <li>The bot must be in a channel to be able to know which users are in
	 * it.</li>
	 * </ul>
	 * 
	 * @since PircBot 1.0.0
	 * 
	 * @param channel
	 *            The name of the channel to list.
	 * 
	 * @return An array of User objects. This array is empty if we are not in
	 *         the channel.
	 * 
	 * @see #onUserList(String,User[]) onUserList
	 */
	public User[] getUsers(String channel);

	/**
	 * This returns a user instance to use
	 * <p>
	 * This is by no means any faster then looping through it yourself.
	 * 
	 * @param channel
	 *            Channelname to grab the user from
	 * @param name
	 *            Name of the user you want to grab
	 * @return User
	 */
	public User getUser(String channel, String name);

	/**
	 * Returns an array of all channels that we are in. Note that if you call
	 * this method immediately after joining a new channel, the new channel may
	 * not appear in this array as it is not possible to tell if the join was
	 * successful until a response is received from the IRC server.
	 * 
	 * @since PircBot 1.0.0
	 * 
	 * @return A String array containing the names of all channels that we are
	 *         in.
	 */
	public String[] getChannels();

	/**
	 * Disposes of all thread resources used by this PircBot. This may be useful
	 * when writing bots or clients that use multiple servers (and therefore
	 * multiple PircBot instances) or when integrating a PircBot with an
	 * existing program.
	 * <p>
	 * Each PircBot runs its own threads for dispatching messages from its
	 * outgoing message queue and receiving messages from the server. Calling
	 * dispose() ensures that these threads are stopped, thus freeing up system
	 * resources and allowing the PircBot object to be garbage collected if
	 * there are no other references to it.
	 * <p>
	 * Once a PircBot object has been disposed, it should not be used again.
	 * Attempting to use a PircBot that has been disposed may result in
	 * unpredictable behaviour.
	 * 
	 * @since 1.2.2
	 */
	public void dispose();
}
