package me.JamieSinn.Bukkit;

import java.util.logging.Logger;
import org.bukkit.World;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Pikachu extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Pikachu Plugin;
	
	@Override
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}
		
	@Override
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() +  " Has Been Successfully Enabled!" + "by JamieSinn");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player) sender;
		World world = player.getWorld();
		if (commandLabel.equalsIgnoreCase("pikachu"))
		{
			if (args.length == 0)
			{

				player.sendMessage(ChatColor.DARK_RED + "Improper Syntax /pikachu <username>");

			}
			else if(args.length == 1)
			{
				if(player.getServer().getPlayer(args[0]) !=null)
				{
				Player targetPlayer1 = player.getServer().getPlayer(args [0]);
				Location location = targetPlayer1.getLocation();
				world.strikeLightning(location);
				world.createExplosion(location, 2);
				player.sendMessage(ChatColor.YELLOW + "Pikachuu!!");
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE");
			}
		}
		if (commandLabel.equalsIgnoreCase("seehealth"))
		{
			if (args.length == 0)
			{

				player.sendMessage(ChatColor.GREEN + "Your Health is:" + player.getHealth());

			}
			else if(args.length == 1)
			{
				if(player.getServer().getPlayer(args[0]) !=null)
				{
				Player targetPlayer1 = player.getServer().getPlayer(args [0]);

			 player.sendMessage(ChatColor.GREEN  + "Target Player Health is: " + targetPlayer1.getHealth());
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "PLAYER NOT ONLINE");
			}
		}
		return false;
	 
	
	}

}
