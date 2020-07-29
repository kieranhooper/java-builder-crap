// EquipmentGetter
//
// This is supposed to get equipment from the static.drips and convert it into something
// my program can deal with.


import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.image.*;
// import java.io.*;
import javax.imageio.*;

//import equipmentdata.*;

public class EquipmentGetter 
{
	URL gearURL;
	URLConnection uc;
	BufferedReader in;
	
	ArrayList<Equippable> staffs = new ArrayList<Equippable>();
	ArrayList<Equippable> wands = new ArrayList<Equippable>();
	ArrayList<Equippable> daggers = new ArrayList<Equippable>();
	ArrayList<Equippable> bows = new ArrayList<Equippable>();
	ArrayList<Equippable> swords = new ArrayList<Equippable>();
	ArrayList<Equippable> katanas = new ArrayList<Equippable>();
	
	ArrayList<Equippable> spellbombs = new ArrayList<Equippable>();
	ArrayList<Equippable> skulls = new ArrayList<Equippable>();
	ArrayList<Equippable> orbs = new ArrayList<Equippable>();
	
	ArrayList<Equippable> tomes = new ArrayList<Equippable>();
	ArrayList<Equippable> scepters = new ArrayList<Equippable>();
	
	ArrayList<Equippable> helms = new ArrayList<Equippable>();
	ArrayList<Equippable> shields = new ArrayList<Equippable>();
	ArrayList<Equippable> seals = new ArrayList<Equippable>();
	
	ArrayList<Equippable> quivers = new ArrayList<Equippable>();
	ArrayList<Equippable> traps = new ArrayList<Equippable>();
	
	ArrayList<Equippable> cloaks = new ArrayList<Equippable>();
	ArrayList<Equippable> prisms = new ArrayList<Equippable>();
	ArrayList<Equippable> poisons = new ArrayList<Equippable>();
	
	ArrayList<Equippable> stars = new ArrayList<Equippable>();
	ArrayList<Equippable> wakis = new ArrayList<Equippable>();
	
	ArrayList<Equippable> lutes = new ArrayList<Equippable>();
	
	ArrayList<Equippable> robes = new ArrayList<Equippable>();
	ArrayList<Equippable> leathers = new ArrayList<Equippable>();
	ArrayList<Equippable> heavies = new ArrayList<Equippable>();
	
	ArrayList<Equippable> rings = new ArrayList<Equippable>();
	
	ArrayList<Equippable> recbanlist = new ArrayList<Equippable>();
	
	BufferedImage lofiObj = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lofiObj.png"));
	BufferedImage lofiObj2 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lofiObj2.png"));
	BufferedImage lofiObj3 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lofiObj3.png"));
	BufferedImage lofiObj4 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lofiObj4.png"));
	BufferedImage lofiObj5 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lofiObj5.png"));
	BufferedImage lofiObj5b = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lofiObj5b.png"));
	BufferedImage lofiObj6 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lofiObj6.png"));
	BufferedImage lostHallsObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lostHallsObjects8x8.png"));
	BufferedImage d2LofiObjEmbed = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/d2LofiObj.png"));
	BufferedImage d3LofiObjEmbed = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/d3LofiObj.png"));
	BufferedImage epicHiveObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/epicHiveObjects8x8.png"));
	BufferedImage lairOfDraconisObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/lairOfDraconisObjects8x8.png"));
	BufferedImage buffedBunnyObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/buffedBunnyObjects8x8.png"));
	BufferedImage crystalCaveObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/crystalCaveObjects8x8.png"));
	BufferedImage cnidarianReefObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/cnidarianReefObjects8x8.png"));
	BufferedImage cursedLibraryObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/cursedLibraryObjects8x8.png"));
	BufferedImage magicWoodsObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/magicWoodsObjects8x8.png"));
	BufferedImage mountainTempleObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/mountainTempleObjects8x8.png"));
	BufferedImage oryxHordeObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/oryxHordeObjects8x8.png"));
	BufferedImage parasiteDenObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/parasiteDenObjects8x8.png"));
	BufferedImage secludedThicketObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/secludedThicketObjects8x8.png"));
	BufferedImage stPatricksObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/stPatricksObjects8x8.png"));
	BufferedImage theMachineObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/theMachineObjects8x8.png"));
	BufferedImage santaWorkshopObjects8x8 = ImageIO.read(new URL("https://static.drips.pw/rotmg/production/current/sheets/santaWorkshopObjects8x8.png"));
	
	public EquipmentGetter() throws IOException
	{
		URL gearURL = new URL("https://static.drips.pw/rotmg/production/current/xmlc/Objects.xml");
		
		URLConnection uc = gearURL.openConnection();
		
		in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		/*
		File lofiObjSrc = new File("Images/lofiObj.png");
		ImageIO.write(lofiObj, "png", lofiObjSrc);
		File lofiObj2Src = new File("Images/lofiObj2.png");
		ImageIO.write(lofiObj2, "png", lofiObj2Src);
		File lofiObj3Src = new File("Images/lofiObj3.png");
		ImageIO.write(lofiObj3, "png", lofiObj3Src);
		File lofiObj4Src = new File("Images/lofiObj4.png");
		ImageIO.write(lofiObj4, "png", lofiObj4Src);
		File lofiObj5Src = new File("Images/lofiObj5.png");
		ImageIO.write(lofiObj5, "png", lofiObj5Src);
		ImageIO.write(lofiObj5b, "png", new File("Images/lofiObj5b.png"));
		ImageIO.write(lofiObj6, "png", new File("Images/lofiObj6.png"));
		*/
		

		// System.out.println(this.connectionWorking());
		
		this.populateArrayLists();
	}
	
	@SuppressWarnings("unused")
	public boolean connectionWorking()
	{
		try
		{
			String s = in.readLine();
		}
		catch (IOException e)
		{
			return false;
		}
		return true;
	}
	
	public String getOneItem() throws IOException
	{
		String s = in.readLine();
		if (s == null)
			return "</Objects>";
		while (!s.contains("</Object>") && !s.contains("</Objects>"))
			s += "\n" + in.readLine();
		return s;
	}
	
	public Equippable xmlToEquippable(String s) throws IOException
	{
		// scan line-by-line, don't check the string overall
		/*
		- <File> image file sprite is found in
		- <Index> location in that image
		- <SlotType> what kind of gear
		- <Description>
		- <DisplayID> seems to be the actual name of the item
		<BagType>
		- <SoulBound/> is present if the item is soulbound
		<feedPower>
		- <Tier>
		- <RateOfFire> expressed as a number, not a percentage
		- <Speed> projectile speed
		- <MinDamage>
		- <MaxDamage>
		- <LifetimeMS> projectile lifetime
		- <NumProjectiles>
		- <ArcGap> does this have a default value? is it 11.25?
		- <MultiHit/> is present if multihit
		- <FameBonus>
		- <ArmorPiercing/>
		- <Parametric/>
		- <PassesCover/>
		<ConditionEffect duration="x"> x is the condition and what's inside the standard zone is the effect name
		- <ActivateOnEquip stat="x" amount ="y"> x is a code for a stat and y is the amount. this will be repeatedly listed on separate lines for each stat affected. Seems to take an argument of IncrementStat no matter what?
		- <MpCost>
		<Activate> what it does on activation? every class has a different thing
		<Size> hitbox size? more likely to be sprite size
		<Activate stat="x" amount="y" duration="z"> temporary stat changes -- StatBoostSelf or StatBoostAura argument
		- <Activate useWisMod="true"> wismod is a boolean rather than specified on an item-by-item basis i guess
		<Activate effect="effect"> status effects on self/party
		<Activate maxDistance, minDistance> limits targeting range with cursor
		<"" radius, impactDamage, totalDamage, duration, throwTime>
		<"" totalDamage, heal, wisDamageBase, ignoreDef, hitsForSelfPuri, hitsForGroupPuri>
		<"" condDuration, condEffect, sensitivity>
		<"" color, target, center, visualEffect>
		<"" speed, angleOffset, objectId, proc, maxWait, mustAlwaysEquip>
		<"" totalDamage, decrDamage, wisDamageBase, maxTargets, wisPerTarget>
		<"" numShots, gapAngle, gapTiles, offsetAngle>
		<"" checkExistingEffect> this is something the geb tome does, but it's hard to say exactly what it means tbh
		<"" noStack> keeps stat boosts separate from other stat boosts -- like pally hp buff?
		<"" enamblePetManaHealing, enableManaRegen, enableGenericManaHealing>
		- <Amplitude>
		- <Frequency>
		- <MultiPhase/> i think this means that it  has two modes (key held, key released). the ability description seems to only contain key released data.
		- <Boomerang/>
		<Object ... setType, setName>
		- <ExtraToolTipData> stores information to convey to the player that isn't part of the item directly -- including if it's alien gear
		- <Cooldown>
		<Magnitude>
		<OnPlayerHitActivate hpMinThreshold, proc, cooldown, duration, amount, range, color, target, center, distance, angleOffset, speed, objectId, impactDamage, totalDamage, duration, throwTime>
		*/
		// https://stackoverflow.com/questions/621835/how-to-extract-part-of-this-image-in-java
		String name = "";
		String nameCode = "";
		String tier = "";
		String desc = ""; 
		String fileName = "";
		String spriteIndex = "";
		String toolTip = "";
		String setName = "";
		String conditionEnemy = "";
		int slotType = 10;
		int rof = 0;
		int minDamage = 0;
		int maxDamage = 0;
		double projSpeed = 0;
		double projLifetime = 0;
		int numProjectiles = 0;
		int fame = 0;
		int hp = 0; 
		int mp = 0;
		int atk = 0;
		int def = 0;
		int spd = 0;
		int dex = 0;
		int vit = 0;
		int wis = 0;
		int mpCost = 0; 
		int bagType = 1;
		int setID = 0;
		double arcGap = 0;
		double amplitude = 0;
		double frequency = 0;
		double cooldown = 0.5;
		boolean soulbound = false;
		boolean multihit = false;
		boolean armorPiercing = false;
		boolean parametric = false;
		boolean passesCover = false;
		boolean wismod = false;
		boolean multiPhase = false;
		boolean boomerang = false;
		boolean wavy = false;
		BufferedImage sprite = null; //ImageIO.read(new File("Images/art.png"));
		
		// finds slot type
		if (s.contains("<SlotType>"))
		{
			slotType = Integer.parseInt(s.substring(s.indexOf("<SlotType>")+10, s.indexOf("</SlotType>")));
		}
		
		if (slotType == 10)
		{
			return new Equippable();
		}
		
		if (!s.contains("<Class>Equipment</Class>"))
		{
			return new Equippable();
		}
		
		// bag type
		if (s.contains("<BagType>"))
		{
			bagType = Integer.parseInt(s.substring(s.indexOf("<BagType>")+9, s.indexOf("</BagType>")));
		}
		
		// finds the name of the item
		if (s.contains("id=\""))
		{
			name = s.substring(s.indexOf("id=\"")+4, s.indexOf('"', s.indexOf("id=\"")+4));
			if (s.contains("<DisplayId>"))
			{
				name = s.substring(s.indexOf("<DisplayId>")+11, s.indexOf("</DisplayId>"));
			}
			String tort = name;
			int index = 0;
			while (name.indexOf("'", index) != -1)
			{
				index += 2;
				try {
					tort = name.substring(0, name.indexOf("'", index)) + "\\'" + name.substring(name.indexOf("'",index)+1, name.length());
					index = name.indexOf("'", index);
					name = tort;
				}
				catch(StringIndexOutOfBoundsException e)
				{
					index = name.length();
				}
			}
		}
		
		// internal id
		if (s.contains("type=\""))
		{
			nameCode = s.substring(s.indexOf("type=\"")+6, s.indexOf('"', s.indexOf("type=\"")+6));
		}
		
		// finds the tier of the item
		if (s.contains("<Tier>"))
		{
			tier = "T" + s.substring(s.indexOf("<Tier>")+6, s.indexOf("</Tier>"));
		}
		else if (s.contains("setName="))
		{
			tier = "ST";
		}
		else
		{
			tier = "UT";
		}
		
		// item description
		if (s.contains("<Description>"))
		{
			desc = s.substring(s.indexOf("<Description>")+13, s.indexOf("</Description>"));
			String tort = desc;
			int index = 0;
			while (desc.indexOf("'", index) != -1)
			{
				index += 2;
				try {
					tort = desc.substring(0, desc.indexOf("'", index)) + "\\'" + desc.substring(desc.indexOf("'",index)+1, desc.length());
					index = desc.indexOf("'", index);
					desc = tort;
				}
				catch(StringIndexOutOfBoundsException e)
				{
					index = desc.length();
				}
			}
		}
		
		// rof
		if (s.contains("<RateOfFire>"))
		{
			rof = (int) (100 * Double.parseDouble(s.substring(s.indexOf("<RateOfFire>")+12, s.indexOf("</RateOfFire>"))));
		}
		
		// min damage
		if (s.contains("<MinDamage>"))
		{
			minDamage = Integer.parseInt(s.substring(s.indexOf("<MinDamage>") + 11, s.indexOf("</MinDamage>")));
		}
		
		// max damage
		if (s.contains("<MaxDamage>"))
		{
			maxDamage = Integer.parseInt(s.substring(s.indexOf("<MaxDamage>") + 11, s.indexOf("</MaxDamage>")));
		}
		
		// passive stats
		//TODO kill self
		// they put amount and stat in a different order on 32 items
		String pft = s.substring(0, s.length());
		String ts = s.substring(0, s.length());
		while (pft.contains("</ActivateOnEquip>"))
		{
			ts = pft.substring(pft.indexOf("<ActivateOnEquip"), pft.indexOf("</ActivateOnEquip"));
			if (ts.contains("stat=\"20\""))
				atk = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			if (ts.contains("stat=\"21\""))
				def = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			if (ts.contains("stat=\"22\""))
				spd = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			if (ts.contains("stat=\"26\""))
				vit = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			if (ts.contains("stat=\"27\""))
				wis = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			if (ts.contains("stat=\"28\""))
				dex = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			if (ts.contains("stat=\"0\""))
				hp = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			if (ts.contains("stat=\"3\""))
				mp = Integer.parseInt(ts.substring(ts.indexOf("amount=\"")+8, ts.indexOf("\"", ts.indexOf("amount=\"")+9)));
			
			
			pft = pft.substring(pft.indexOf("</ActivateOnEquip>")+1);
		}
		
		
		
		/*
		if (s.contains("<ActivateOnEquip stat=\"20\" amount=\""))
		{
			atk = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"20\" amount=\"")+35, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"20\" amount=\""))));
		}
		if (s.contains("<ActivateOnEquip stat=\"21\" amount=\""))
		{
			def = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"21\" amount=\"")+35, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"21\" amount=\""))));
		}
		if (s.contains("<ActivateOnEquip stat=\"22\" amount=\""))
		{
			spd = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"22\" amount=\"")+35, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"22\" amount=\""))));
		}
		if (s.contains("<ActivateOnEquip stat=\"26\" amount=\""))
		{
			vit = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"26\" amount=\"")+35, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"26\" amount=\""))));
		}
		if (s.contains("<ActivateOnEquip stat=\"27\" amount=\""))
		{
			wis = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"27\" amount=\"")+35, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"27\" amount=\""))));
		}
		if (s.contains("<ActivateOnEquip stat=\"28\" amount=\""))
		{
			dex = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"28\" amount=\"")+35, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"28\" amount=\""))));
		}
		if (s.contains("<ActivateOnEquip stat=\"0\" amount=\""))
		{
			hp = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"0\" amount=\"")+34, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"0\" amount=\""))));
		}
		if (s.contains("<ActivateOnEquip stat=\"3\" amount=\""))
		{
			mp = Integer.parseInt(s.substring(s.indexOf("<ActivateOnEquip stat=\"3\" amount=\"")+34, s.indexOf("\">IncrementStat</ActivateOnEquip>", s.indexOf("<ActivateOnEquip stat=\"3\" amount=\""))));
		}
		*/
		
		// booleans
		if (s.contains("<Soulbound/>"))
			soulbound = true;
		if (s.contains("<MultiHit/>"))
			multihit = true;
		if (s.contains("<ArmorPiercing/>"))
			armorPiercing = true;
		if (s.contains("<Parametric/>"))
			parametric = true;
		if (s.contains("<PassesCover/>"))
			passesCover = true;
		if (s.contains("useWisMod=\"true\""))
			wismod = true;
		if (s.contains("<MultiPhase/>"))
			multiPhase = true;
		if (s.contains("<Boomerang/>"))
			boomerang = true;
		if (s.contains("<Wavy/>"))
			wavy = true;
		
		// proj speed/lifetime
		// bonus line that sets numProjectiles to the default if there is a projectile
		if (s.contains("<Projectile"))
		{
			numProjectiles = 1;
			String smini = s.substring(s.indexOf("<Projectile"), s.indexOf("</Projectile>"));
			if (smini.contains("<Speed>"))
				projSpeed = Double.parseDouble(smini.substring(smini.indexOf("<Speed>")+7, smini.indexOf("</Speed>")));
			if (smini.contains("<LifetimeMS>"))
				projLifetime = Double.parseDouble(smini.substring(smini.indexOf("<LifetimeMS>")+12, smini.indexOf("</LifetimeMS>")));
		}
		
		// if multishot make it so
		// bonus line sets default arcgap
		if (s.contains("<NumProjectiles>"))
		{
			numProjectiles = Integer.parseInt(s.substring(s.indexOf("<NumProjectiles>")+16, s.indexOf("</NumProjectiles>")));
			if (numProjectiles>1)
				arcGap = 11.25;
		}
		
		// actual arcgap if different
		if (s.contains("<ArcGap>"))
		{
			arcGap = Double.parseDouble(s.substring(s.indexOf("<ArcGap>")+8, s.indexOf("</ArcGap>")));
		}
		
		// grabs fame
		if (s.contains("<FameBonus>"))
		{
			fame = Integer.parseInt(s.substring(s.indexOf("<FameBonus>")+11, s.indexOf("</FameBonus>")));
		}
		
		// finds ST set
		if (s.contains("setName=\""))
		{
			// keep an eye on this line. it fucked up unexpectedly with the new huntress ST
			setName = s.substring(s.indexOf("setName=\"")+9, s.indexOf("\"", s.indexOf("setName=\"")+9));
			if (setName.equals("Twilight Archmage Set"))
				setID = 1;
			else if (setName.equals("Priest of Geb Set"))
				setID = 2;
			else if (setName.equals("Skuld 2 The ReGhostening Set"))
				setID = 3;
			else if (setName.equals("Phantom Archer Set"))
				setID = 4;
			else if (setName.equals("Dragon Tamer Set"))
				setID = 5;
			else if (setName.equals("Oryx's Battle Attires"))
				setID = 6;
			else if (setName.equals("Swoll Paladin Set"))
				setID = 7;
			else if (setName.equals("Flesh Collector Set"))
				setID = 8;
			else if (setName.equals("Hollow King Necromancer Set"))
				setID = 9;
			else if (setName.equals("Swarming Hunress Set"))
				setID = 10;
			else if (setName.equals("Phylactery Mystic Set"))
				setID = 11;
			else if (setName.equals("Lost Golem Set"))
				setID = 12;
			else if (setName.equals("Horrific Sorcerer Set"))
				setID = 13;
			else if (setName.equals("Raijin Disciple Set"))
				setID = 14;
			else if (setName.equals("Akuma Slayer Set"))
				setID = 15;
			else if (setName.equals("Alien Core: Power"))
				setID = 16;
			else if (setName.equals("Alien Core: Dark Matter"))
				setID = 17;
			else if (setName.equals("Alien Core: Corrosion"))
				setID = 18;
			else if (setName.equals("Alien Core: Warp"))
				setID = 19;
			else if (setName.equals("Entropy Reactor") || setName.equals("Loaded Core"))
				setID = 20;
			else if (setName.equals("Golden Archer Set"))
				setID = 21;
			else if (setName.equals("Scarecrow Trickster Set"))
				setID = 22;
			else if (setName.equals("Reanimated Archer Set"))
				setID = 23;
			else if (setName.equals("Unholy Paladin Set"))
				setID = 24;
			else if (setName.equals("Totalia Mystic Set"))
				setID = 25;
			else
			{
				setID = setName.hashCode();
			}
		}
		
		if (s.contains("<ExtraTooltipData>"))
		{
			toolTip = s.substring(s.indexOf("<ExtraTooltipData>")+18, s.indexOf("</ExtraTooltipData>"));
			
			int index = 0;
			String tort = toolTip;
			while (toolTip.indexOf("'", index) != -1)
			{
				index += 2;
				try {
					tort = toolTip.substring(0, toolTip.indexOf("'", index)) + "\\'" + toolTip.substring(toolTip.indexOf("'",index)+1, toolTip.length());
					index = toolTip.indexOf("'", index);
					toolTip = tort;
				}
				catch(StringIndexOutOfBoundsException e)
				{
					index = toolTip.length();
				}
			}	
		}
		
		if (s.contains("<ConditionEffect "))
		{
			conditionEnemy = s.substring(s.indexOf("<ConditionEffect ")+17, s.indexOf("</ConditionEffect>"))+ ",";
			if (s.indexOf("<ConditionEffect ", s.indexOf("<ConditionEffect ")+5) > 0)
			{
				String contin = s.substring(s.indexOf("<ConditionEffect ", s.indexOf("<ConditionEffect ")+5)+17, s.indexOf("</ConditionEffect", s.indexOf("</ConditionEffect>")+5))+ ",";
				if (!contin.equals(conditionEnemy))
				{
					//System.out.println(conditionEnemy + "\n" + contin + "\n\n");
					conditionEnemy += " " + contin;
				}
				else
				{
					//System.out.println("No difference: trashed");
				}
			}
		}
		
		if (s.contains("<Amplitude>"))
		{
			amplitude = Double.parseDouble(s.substring(s.indexOf("<Amplitude>")+11, s.indexOf("</Amplitude>")));
		}
		
		if (s.contains("<Frequency>"))
		{
			frequency = Double.parseDouble(s.substring(s.indexOf("<Frequency>")+11, s.indexOf("</Frequency>")));
		}
		
		if (s.contains("<MpCost>"))
		{
			mpCost = Integer.parseInt(s.substring(s.indexOf("<MpCost>")+8, s.indexOf("</MpCost>")));
		}
		
		if (s.contains("<MpEndCost>"))
		{
			mpCost = Integer.parseInt(s.substring(s.indexOf("<MpEndCost>")+11, s.indexOf("</MpEndCost>")));
		}
		
		if (s.contains("<Cooldown>"))
		{
			cooldown = Double.parseDouble(s.substring(s.indexOf("<Cooldown>")+10, s.indexOf("</Cooldown>")));
		}
		
		// sprite index cheat sheet
		// base 16 (a,b,c,d,e,f represent extra digits)
		//
		// 0xij --> [i,j]
		// 0xijk --> [ij,k]
		// ij --> index, not coords
		// where i, j, and k represent variable digit values

		// filename ez
		
		int frow = 0;
		int fcol = 0;
		if (s.contains("<File>"))
		{
			fileName = s.substring(s.indexOf("<File>")+6, s.indexOf("</File>"));
		}
		
		// final boss
		// get sprite from images based on the index as specified
		if (s.contains("<Index>"))
		{
			spriteIndex = s.substring(s.indexOf("<Index>")+7, s.indexOf("</Index>"));
			
			String spriteRow = "";
			String spriteColumn = "";
			BufferedImage fileMommy = null;
			
			int row = 0;
			int column = 0;
			
			if (spriteIndex.contains("0x"))
			{
				if (spriteIndex.length() == 5)
				{
					spriteRow = spriteIndex.substring(2, 4);
					spriteColumn = spriteIndex.substring(4);
					
					if (Character.isDigit(spriteRow.charAt(1)))
					{
						row += Integer.parseInt(Character.toString(spriteRow.charAt(1)));
					}
					else
					{
						char tb = spriteRow.charAt(1);
						if (tb == 'a' || tb == 'A')
							row += 10;
						else if (tb == 'b' || tb == 'B')
							row += 11;
						else if (tb == 'c' || tb == 'C')
							row += 12;
						else if (tb == 'd' || tb == 'D')
							row += 13;
						else if (tb == 'e' || tb == 'E')
							row += 14;
						else if (tb == 'f' || tb == 'F')
							row += 15;
					}
					if (Character.isDigit(spriteRow.charAt(0)))
					{
						row += ( 16 * Integer.parseInt(Character.toString(spriteRow.charAt(0))));
					}
					else
					{
						char tc = spriteRow.charAt(1);
						if (tc == 'a' || tc == 'A')
							row += 160;
						else if (tc == 'b' || tc == 'B')
							row += 320;
						else if (tc == 'c' || tc == 'C')
							row += 480;
						else if (tc == 'd' || tc == 'D')
							row += 640;
						else if (tc == 'e' || tc == 'E')
							row += 800;
						else if (tc == 'f' || tc == 'F')
							row += 960;
					}
					if (Character.isDigit(spriteColumn.charAt(0)))
					{
						column += Integer.parseInt(Character.toString(spriteColumn.charAt(0)));
					}
					else
					{
						char tb = spriteColumn.charAt(0);
						if (tb == 'a' || tb == 'A')
							column += 10;
						else if (tb == 'b' || tb == 'B')
							column += 11;
						else if (tb == 'c' || tb == 'C')
							column += 12;
						else if (tb == 'd' || tb == 'D')
							column += 13;
						else if (tb == 'e' || tb == 'E')
							column += 14;
						else if (tb == 'f' || tb == 'F')
							column += 15;
					}
				}
				else
				{
					spriteRow = spriteIndex.substring(2,3);
					spriteColumn = spriteIndex.substring(3);
					
					if (Character.isDigit(spriteRow.charAt(0)))
					{
						row += Integer.parseInt(Character.toString(spriteRow.charAt(0)));
					}
					else
					{
						char tb = spriteRow.charAt(0);
						if (tb == 'a' || tb == 'A')
							row += 10;
						else if (tb == 'b' || tb == 'B')
							row += 11;
						else if (tb == 'c' || tb == 'C')
							row += 12;
						else if (tb == 'd' || tb == 'D')
							row += 13;
						else if (tb == 'e' || tb == 'E')
							row += 14;
						else if (tb == 'f' || tb == 'F')
							row += 15;
					}
					if (Character.isDigit(spriteColumn.charAt(0)))
					{
						column += Integer.parseInt(Character.toString(spriteColumn.charAt(0)));
					}
					else
					{
						char tb = spriteColumn.charAt(0);
						if (tb == 'a' || tb == 'A')
							column += 10;
						else if (tb == 'b' || tb == 'B')
							column += 11;
						else if (tb == 'c' || tb == 'C')
							column += 12;
						else if (tb == 'd' || tb == 'D')
							column += 13;
						else if (tb == 'e' || tb == 'E')
							column += 14;
						else if (tb == 'f' || tb == 'F')
							column += 15;
					}
				}
			}
			
			if (fileName.equals("lofiObj"))
			{
				fileMommy = lofiObj;
			}
			else if (fileName.equals("lofiObj2"))
			{
				fileMommy = lofiObj2;
			}
			else if (fileName.equals("lofiObj3"))
			{
				fileMommy = lofiObj3;
			}
			else if (fileName.equals("lofiObj4"))
			{
				fileMommy = lofiObj4;
			}
			else if (fileName.equals("lofiObj5"))
			{
				fileMommy = lofiObj5;
			}
			else if (fileName.equals("lofiObj5new"))
			{
				fileMommy = lofiObj5b;
			}
			else if (fileName.equals("lofiObj6"))
			{
				fileMommy = lofiObj6;
			}
			else if (fileName.equals("lostHallsObjects8x8"))
			{
				fileMommy = lostHallsObjects8x8;
			}
			else if (fileName.equals("d2LofiObjEmbed"))
			{
				fileMommy = d2LofiObjEmbed;
			}
			else if (fileName.equals("d3LofiObjEmbed"))
			{
				fileMommy = d3LofiObjEmbed;
			}
			else if (fileName.equals("epicHiveObjects8x8"))
			{
				fileMommy = epicHiveObjects8x8;
			}
			else if (fileName.equals("lairOfDraconisObjects8x8"))
			{
				fileMommy = lairOfDraconisObjects8x8;
			}
			else if (fileName.equals("buffedBunnyObjects8x8"))
			{
				fileMommy = buffedBunnyObjects8x8;
			}
			else if (fileName.equals("crystalCaveObjects8x8"))
			{
				fileMommy = crystalCaveObjects8x8;
			}
			else if (fileName.equals("cnidarianReefObjects8x8"))
			{
				fileMommy = cnidarianReefObjects8x8;
			}
			else if (fileName.equals("cursedLibraryObjects8x8"))
			{
				fileMommy = cursedLibraryObjects8x8;
			}
			else if (fileName.equals("magicWoodsObjects8x8"))
			{
				fileMommy = magicWoodsObjects8x8;
			}
			else if (fileName.equals("mountainTempleObjects8x8"))
			{
				fileMommy = mountainTempleObjects8x8;
			}
			else if (fileName.equals("oryxHordeObjects8x8"))
			{
				fileMommy = oryxHordeObjects8x8;
			}
			else if (fileName.equals("parasiteDenObjects8x8"))
			{
				fileMommy = parasiteDenObjects8x8;
			}
			else if (fileName.equals("secludedThicketObjects8x8"))
			{
				fileMommy = secludedThicketObjects8x8;
			}
			else if (fileName.equals("stPatricksObjects8x8"))
			{
				fileMommy = stPatricksObjects8x8;
			}
			else if (fileName.equals("theMachineObjects8x8"))
			{
				fileMommy = theMachineObjects8x8;
			}
			else if (fileName.equals("santaWorkshopObjects8x8"))
			{
				fileMommy = santaWorkshopObjects8x8;
			}
			
			if (spriteIndex.length() == 2)
			{
				int spritecode = Integer.parseInt(spriteIndex);
				int momwidth = fileMommy.getWidth();
				momwidth = momwidth/8;
				while (spritecode > momwidth)
				{
					spritecode -= momwidth;
					row += 1;
				}
				column = spritecode;
			}
			
			if (fileMommy != null)
			{
				sprite = fileMommy.getSubimage(column * 8, row * 8, 8, 8);
			}
			frow = row;
			fcol = column;
		}
		
		return new Equippable(name, tier, desc, toolTip, slotType, rof, minDamage, maxDamage, projSpeed, projLifetime, numProjectiles, fame, hp, mp, atk, def, spd, dex, vit, wis, setID, arcGap, amplitude, frequency, multihit, armorPiercing, parametric, passesCover, boomerang, sprite, setName, soulbound, frow, fcol, fileName, wavy, nameCode, bagType, mpCost, cooldown, conditionEnemy);
		/*
		if (slotType != 11 && slotType != 4 && slotType != 13 &&
				slotType != 15 && slotType != 16 && slotType != 5 &&
				slotType != 12 && slotType != 18 && slotType != 19 &&
				slotType != 20 && slotType != 21 && slotType != 22 &&
				slotType != 23 && slotType != 25 && slotType != 27)
		{
			return new Equippable(name, tier, desc, toolTip, slotType, rof, minDamage, maxDamage, projSpeed, projLifetime, numProjectiles, fame, hp, mp, atk, def, spd, dex, vit, wis, setID, arcGap, amplitude, frequency, multihit, armorPiercing, parametric, passesCover, boomerang, sprite, setName);
		}
		//TODO abilities
		
		
		return new Equippable(name, tier, desc, toolTip, slotType, rof, minDamage, maxDamage, projSpeed, projLifetime, numProjectiles, fame, hp, mp, atk, def, spd, dex, vit, wis, setID, arcGap, amplitude, frequency, multihit, armorPiercing, parametric, passesCover, boomerang, sprite, setName);;
		*/
	}
	
	public void getSwords(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < swords.size(); i++)
		{
			pw.print(swords.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        swords.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getStaffs(PrintWriter pw) 
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < staffs.size(); i++)
		{
			pw.print(staffs.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        staffs.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getWands(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < wands.size(); i++)
		{
			pw.print(wands.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        wands.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getDaggers(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < daggers.size(); i++)
		{
			pw.print(daggers.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        daggers.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getKatanas(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < katanas.size(); i++)
		{
			pw.print(katanas.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        katanas.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getBows(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < bows.size(); i++)
		{
			pw.print(bows.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        bows.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getRobes(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < robes.size(); i++)
		{
			pw.print(robes.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        robes.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getLeathers(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < leathers.size(); i++)
		{
			pw.print(leathers.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        leathers.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getHeavies(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < heavies.size(); i++)
		{
			pw.print(heavies.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        heavies.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getRings(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < rings.size(); i++)
		{
			pw.print(rings.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        rings.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getSpellbombs(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < spellbombs.size(); i++)
		{
			pw.print(spellbombs.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        spellbombs.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getCloaks(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < cloaks.size(); i++)
		{
			pw.print(cloaks.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        cloaks.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getQuivers(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < quivers.size(); i++)
		{
			pw.print(quivers.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        quivers.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getTomes(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < tomes.size(); i++)
		{
			pw.print(tomes.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        tomes.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getHelms(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < helms.size(); i++)
		{
			pw.print(helms.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        helms.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getShields(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < shields.size(); i++)
		{
			pw.print(shields.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        shields.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getSeals(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < seals.size(); i++)
		{
			pw.print(seals.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        seals.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getPoisons(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < poisons.size(); i++)
		{
			pw.print(poisons.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        poisons.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getSkulls(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < skulls.size(); i++)
		{
			pw.print(skulls.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        skulls.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getTraps(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < traps.size(); i++)
		{
			pw.print(traps.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        traps.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getOrbs(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < orbs.size(); i++)
		{
			pw.print(orbs.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        orbs.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getPrisms(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < prisms.size(); i++)
		{
			pw.print(prisms.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        prisms.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getScepters(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < scepters.size(); i++)
		{
			pw.print(scepters.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        scepters.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getStars(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < stars.size(); i++)
		{
			pw.print(stars.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        stars.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	public void getWakis(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < wakis.size(); i++)
		{
			pw.print(wakis.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        wakis.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void getLutes(PrintWriter pw)
	{
		pw.print("\n\ns = '");
		for (int i = 0; i < lutes.size(); i++)
		{
			pw.print(lutes.get(i).parsedItem());
		}
		pw.print("';\n\n");
		
		pw.print("while (s.includes(\"<Item>\"))\r\n" + 
				"    {\r\n" + 
				"        var tot = makeItem(s);\r\n" + 
				"        lutes.push(tot);\r\n" + 
				"        s = s.substring(s.indexOf(\"</Item>\")+1, s.length)\r\n" + 
				"    }");
	}
	
	public void populateArrayLists() throws IOException
	{
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/ParsedItems"))));
		
		Equippable anystaff = new Equippable();
		anystaff.setFilePath("Images/staff_any.png");
		//pw.print(anystaff.parsedItem());
		staffs.add(anystaff);
		
		Equippable anywand = new Equippable();
		anywand.setFilePath("Images/wand_any.png");
		//pw.print(anywand.parsedItem());
		wands.add(anywand);
		
		Equippable anydagger = new Equippable();
		anydagger.setFilePath("Images/dagger_any.png");
		//pw.print(anydagger.parsedItem());
		daggers.add(anydagger);
		
		Equippable anybow = new Equippable();
		anybow.setFilePath("Images/bow_any.png");
		//pw.print(anybow.parsedItem());
		bows.add(anybow);
		
		Equippable anysword = new Equippable();
		anysword.setFilePath("Images/sword_any.png");
		//pw.print(anysword.parsedItem());
		swords.add(anysword);
		
		Equippable anykatana = new Equippable();
		anykatana.setFilePath("Images/katana_any.png");
		//pw.print(anykatana.parsedItem());
		katanas.add(anykatana);
		
		Equippable anyrobe = new Equippable();
		anyrobe.setFilePath("Images/robe_any.png");
		//pw.print(anyrobe.parsedItem());
		robes.add(anyrobe);
		
		Equippable anyleather = new Equippable();
		anyleather.setFilePath("Images/leather_any.png");
		//pw.print(anyleather.parsedItem());
		leathers.add(anyleather);
		
		Equippable anyheavy = new Equippable();
		anyheavy.setFilePath("Images/heavy_any.png");
		//pw.print(anyheavy.parsedItem());
		heavies.add(anyheavy);
		
		Equippable anyring = new Equippable();
		anyring.setFilePath("Images/ring_any.png");
		//pw.print(anyring.parsedItem());
		rings.add(anyring);
		
		Equippable anyspellbomb = new Equippable();
		anyspellbomb.setFilePath("Images/spellbomb_any.png");
		//pw.print(anyspellbomb.parsedItem());
		spellbombs.add(anyspellbomb);
		
		Equippable anycloak = new Equippable();
		anycloak.setFilePath("Images/cloak_any.png");
		//pw.print(anycloak.parsedItem());
		cloaks.add(anycloak);
		
		Equippable anyquiver = new Equippable();
		anyquiver.setFilePath("Images/quiver_any.png");
		//pw.print(anyquiver.parsedItem());
		quivers.add(anyquiver);
		
		Equippable anytome = new Equippable();
		anytome.setFilePath("Images/tome_any.png");
		//pw.print(anytome.parsedItem());
		tomes.add(anytome);
		
		Equippable anyhelm = new Equippable();
		anyhelm.setFilePath("Images/helm_any.png");
		//pw.print(anyhelm.parsedItem());
		helms.add(anyhelm);
		
		Equippable anyshield = new Equippable();
		anyshield.setFilePath("Images/shield_any.png");
		//pw.print(anyshield.parsedItem());
		shields.add(anyshield);
		
		Equippable anyseal = new Equippable();
		anyseal.setFilePath("Images/seal_any.png");
		//pw.print(anyseal.parsedItem());
		seals.add(anyseal);
		
		Equippable anypoison = new Equippable();
		anypoison.setFilePath("Images/poison_any.png");
		//pw.print(anypoison.parsedItem());
		poisons.add(anypoison);
		
		Equippable anyskull = new Equippable();
		anyskull.setFilePath("Images/skull_any.png");
		//pw.print(anyskull.parsedItem());
		skulls.add(anyskull);
		
		Equippable anytrap = new Equippable();
		anytrap.setFilePath("Images/trap_any.png");
		//pw.print(anytrap.parsedItem());
		traps.add(anytrap);
		
		Equippable anyorb = new Equippable();
		anyorb.setFilePath("Images/orb_any.png");
		//pw.print(anyorb.parsedItem());
		orbs.add(anyorb);
		
		Equippable anyprism = new Equippable();
		anyprism.setFilePath("Images/prism_any.png");
		//pw.print(anyprism.parsedItem());
		prisms.add(anyprism);
		
		Equippable anyscepter = new Equippable();
		anyscepter.setFilePath("Images/scepter_any.png");
		//pw.print(anyscepter.parsedItem());
		scepters.add(anyscepter);
		
		Equippable anystar = new Equippable();
		anystar.setFilePath("Images/star_any.png");
		//pw.print(anystar.parsedItem());
		stars.add(anystar);
		
		Equippable anywaki = new Equippable();
		anywaki.setFilePath("Images/waki_any.png");
		//pw.print(anywaki.parsedItem());
		wakis.add(anywaki);
		
		Equippable anylute = new Equippable();
		lutes.add(anylute);
		
		String aaa = this.getOneItem();
		
		while (!aaa.contains("</Objects>"))
		{	
			Equippable temp = xmlToEquippable(aaa);
			
			if (aaa.contains("<SlotType>1</SlotType>"))
			{
				swords.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>17</SlotType>"))
			{
				staffs.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>8</SlotType>"))
			{
				wands.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>2</SlotType>"))
			{
				daggers.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>3</SlotType>"))
			{
				bows.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>24</SlotType>"))
			{
				katanas.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>14</SlotType>"))
			{
				robes.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>6</SlotType>"))
			{
				leathers.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>7</SlotType>"))
			{
				heavies.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>9</SlotType>"))
			{
				rings.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>11</SlotType>"))
			{
				spellbombs.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>13</SlotType>"))
			{
				cloaks.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>15</SlotType>") && !aaa.contains("Proc") && !aaa.contains("StarTest"))
			{
				quivers.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>4</SlotType>"))
			{
				tomes.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>16</SlotType>"))
			{
				helms.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>5</SlotType>"))
			{
				shields.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>12</SlotType>"))
			{
				seals.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>18</SlotType>"))
			{
				poisons.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>19</SlotType>"))
			{
				skulls.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>20</SlotType>"))
			{
				traps.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>21</SlotType>"))
			{
				orbs.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>22</SlotType>"))
			{
				prisms.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>23</SlotType>"))
			{
				scepters.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>25</SlotType>"))
			{
				stars.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>27</SlotType>"))
			{
				wakis.add(temp);
				//pw.print(temp.parsedItem());
			}
			else if (aaa.contains("<SlotType>28</SlotType>"))
			{
				lutes.add(temp);
			}
			
			checkBanlist(temp);
			
			aaa = this.getOneItem();
		}
		pw.print("function pullGear() {");
		pw.print("\nvar s = ''");
		getStaffs(pw);
		getWands(pw);
		getSwords(pw);
		getKatanas(pw);
		getBows(pw);
		getDaggers(pw);
		
		getSpellbombs(pw);
		getSkulls(pw);
		getOrbs(pw);
		getTomes(pw);
		getScepters(pw);
		getHelms(pw);
		getShields(pw);
		getSeals(pw);
		getStars(pw);
		getWakis(pw);
		getQuivers(pw);
		getTraps(pw);
		getCloaks(pw);
		getPrisms(pw);
		getPoisons(pw);
		getLutes(pw);
		
		getRobes(pw);
		getLeathers(pw);
		getHeavies(pw);
		
		getRings(pw);
		
		pw.print("\n}");
		
		pw.close();
	}
	
	public ArrayList<Equippable> getBanlist()
	{
		return recbanlist;
	}
	
	private void checkBanlist(Equippable bnob)
	{
		// TODO come back for abilities once those are implemented
		// if the builder pulls any illegal ones.
		String name = bnob.getName();
		if (name.equals("Staff of the Fundamental Core"))
			recbanlist.add(bnob);
		else if (name.equals("Robe of the Ancient Intellect"))
			recbanlist.add(bnob);
		else if (name.equals("Crown"))
			recbanlist.add(bnob);
		else if (name.equals("Dagger of Dire Hatred"))
			recbanlist.add(bnob);
		else if (name.equals("Leviathan Armor"))
			recbanlist.add(bnob);
		else if (name.equals("Bow of Deep Enchantment"))
			recbanlist.add(bnob);
		else if (name.equals("Wand of Retribution"))
			recbanlist.add(bnob);
		else if (name.equals("Sword of Majesty"))
			recbanlist.add(bnob);
		else if (name.equals("Def Test Sword"))
			recbanlist.add(bnob);
		else if (name.equals("Annihilation Armor"))
			recbanlist.add(bnob);
		else if (name.equals("pD Armor"))
			recbanlist.add(bnob);
		else if (name.equals("Kusanagi"))
			recbanlist.add(bnob);
		else if (name.equals("Strike Amulet"))
			recbanlist.add(bnob);
		else if (name.equals("Helm of the Immortal"))
			recbanlist.add(bnob);
		else if (name.equals("Seal of Divine Focus"))
			recbanlist.add(bnob);
		else if (name.equals("Sewer Cocktail"))
			recbanlist.add(bnob);
	}
}

























