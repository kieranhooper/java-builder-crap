

// Equippable
//
// This class forms the basis of all the equipment data stored in this app. It holds all the data relating
// to any equippable piece of equipment except for st bonuses and sprites.

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Equippable 
{
	public int hp,mp,atk,spd,vit,def,dex,wis,fame,baseDamage,maxDamage,rof,shots,st;
	int slotType = 10;
	int row = 0;
	int column = 0;
	int bagType = 0;
	int manaCost = 0;
	public double range,amplitude,frequency, arc;
	double projectileLifetime = 0;
	double projectileSpeed = 0;
	double cooldown = 0.5;
	public String name,description,effect,tier;
	String nameCode = "";
	public String filepath = "Images/Art.png";
	String setName = "";
	String fileName = "";
	BufferedImage sprite = null;
	boolean ignoresDefense = false;
	boolean multiHit = false;
	boolean soulbound = false;
	boolean parametric = false;
	boolean boomerang = false;
	boolean passesCover = false;
	boolean wavy = false;
	public String tooltip = "";
	String conditionEnemy = "";
	
	
	// blank instantiation
	public Equippable()
	{
		hp = 0;
		mp = 0;
		atk = 0;
		spd = 0;
		vit = 0;
		def = 0;
		dex = 0;
		wis = 0;
		fame = 0;
		baseDamage = 0;
		rof = 0;
		maxDamage = 0;
		shots = 0;
		arc = 0;
		st = 0;
		range = 0;
		amplitude = 0;
		frequency = 0;
		name = "(empty slot)";
		description = "";
		effect = "";
		tier = "";
		filepath = "Images/Art.png";
	}

	// non-ability instantiation for EquipmentGetter
	public Equippable(String iname, String itier, String idesc, String itoolTip, int islotType, int irof, int iminDmg, int imaxDmg, double iprojSpeed, double iprojLifetime, int inumProj, int ifame, int ihp, int imp, int iatk, int idef, int ispd, int idex, int ivit, int iwis, int ist, double iarc, double iamp, double ifreq, boolean imultihit, boolean iarmorPierce, boolean iparametric, boolean ipassesCover, boolean iboomerang, BufferedImage isprite, String isetName, boolean isoulbound, int irow, int icolumn, String ifn, boolean iwavy, String inameCode, int ibagType, int imanaCost, double icooldown, String iconditionEnemy)
	{
		hp = ihp;
		mp = imp;
		atk = iatk;
		def = idef;
		spd = ispd;
		dex = idex;
		vit = ivit;
		wis = iwis;
		fame = ifame;
		baseDamage = iminDmg;
		maxDamage = imaxDmg;
		rof = irof;
		shots = inumProj;
		arc = iarc;
		st = ist;
		name = iname;
		description = idesc;
		tier = itier;
		slotType = islotType;
		// TODO is this proper calculation of range?
		projectileSpeed = iprojSpeed;
		projectileLifetime = iprojLifetime;
		range = (iprojSpeed * iprojLifetime)/10000.0;
		amplitude = iamp;
		frequency = ifreq;
		multiHit = imultihit;
		ignoresDefense = iarmorPierce;
		parametric = iparametric;
		boomerang = iboomerang;
		passesCover = ipassesCover;
		sprite = isprite;
		tooltip = itoolTip;
		setName = isetName;
		soulbound = isoulbound;
		row = irow;
		column = icolumn;
		fileName = ifn;
		wavy = iwavy;
		nameCode = inameCode;
		bagType = ibagType;
		manaCost = imanaCost;
		cooldown = icooldown;
		conditionEnemy = iconditionEnemy;
	}
	
	
	// weapon instantiation
	public Equippable(int ihp, int imp, int iatk, int ispd, int ivit, int idef, int idex, int iwis, int ifame, int ibase, int imax, int irof, int ishots, int iarc, double irange, double iamp, double ifreq, String iname, String idesc, String itier, int ist, String ieff)
	{
		hp = ihp;
		mp = imp;
		atk = iatk;
		spd = ispd;
		vit = ivit;
		def = idef;
		dex = idex;
		wis = iwis;
		fame = ifame;
		baseDamage = ibase;
		maxDamage = imax;
		shots = ishots;
		arc = iarc;
		range = irange;
		amplitude = iamp;
		frequency = ifreq;
		st = ist;
		name = iname;
		description = idesc;
		tier = itier;
		rof = irof;
		effect = ieff;
	}
	
	// ability instantiation
	public Equippable(int ihp, int imp, int iatk, int ispd, int ivit, int idef, int idex, int iwis, int ifame, int ibase, int imax, int ishots, int iarc, double irange, double iamp, double ifreq, String iname, String idesc, String ieff, String itier, int ist)
	{
		hp = ihp;
		mp = imp;
		atk = iatk;
		spd = ispd;
		vit = ivit;
		def = idef;
		dex = idex;
		wis = iwis;
		fame = ifame;
		baseDamage = ibase;
		maxDamage = imax;
		shots = ishots;
		arc = iarc;
		range = irange;
		amplitude = iamp;
		frequency = ifreq;
		st = ist;
		name = iname;
		description = idesc;		
		effect = ieff;
		tier = itier;
	}
	
	// armor and ring instantiation
	public Equippable(int ihp, int imp, int iatk, int ispd, int ivit, int idef, int idex, int iwis, int ifame, String iname, String idesc, String ieff, String itier, int ist)
	{
		hp = ihp;
		mp = imp;
		atk = iatk;
		spd = ispd;
		vit = ivit;
		def = idef;
		dex = idex;
		wis = iwis;
		fame = ifame;
		st = ist;
		name = iname;
		description = idesc;	
		effect = ieff;
		tier = itier;
	}

	
	public String parsedItem()
	{
		/*if (slotType != 17)
			return "";*/
		
		String o = "";
		
		o += "<Item>";
		
		o += "<Name>" + name + "</Name>";
		
		o += "<NameCode>" + nameCode + "</NameCode>";
		//if (!description.equals(""))
			o += "<Description>" + description +"</Description>";
		//if (!tier.equals(""))
			o += "<Tier>" + tier + "</Tier>";
		//if (!fileName.equals(""))
			o += "<Filename>" + fileName + "</Filename>";
		o += "<Row>" + row + "</Row>";
		o += "<Column>" + column + "</Column>";
		//if (!setName.equals(""))
			o += "<SetName>" + setName + "</SetName>";
		o += "<SlotType>" + slotType + "</SlotType>";
		//if (hp != 0)
			o += "<HP>" + hp + "</HP>";
		//if (mp != 0)
			o += "<MP>" + mp + "</MP>";
		//if (atk != 0)
			o += "<ATK>" + atk + "</ATK>";
		//if (def != 0)
			o += "<DEF>" + def + "</DEF>";
		//if (spd != 0)
			o += "<SPD>" + spd + "</SPD>";
		//if (dex != 0)
			o += "<DEX>" + dex + "</DEX>";
		//if (vit != 0)
			o += "<VIT>" + vit + "</VIT>";
		//if (wis != 0)
			o += "<WIS>" + wis + "</WIS>";
		//if (fame != 0)
			o += "<Fame>" + fame + "</Fame>";
		if (ignoresDefense)
			o += "</DefIgnore>";
		if (multiHit)
			o += "</MultiHit>";
		if (soulbound)
			o += "</Soulbound>";
		if (passesCover)
			o += "</PassesCover>";
		if (parametric)
			o += "</Parametric>";
		if (boomerang)
			o += "</Boomerang>";
		//if (baseDamage != 0)
			o += "<BaseDamage>" + baseDamage + "</BaseDamage>";
		//if (maxDamage != 0)
			o += "<MaxDamage>" + maxDamage + "</MaxDamage>";
		//if (rof != 0)
			o += "<RateOfFire>" + rof + "</RateOfFire>";
		//if (shots != 0)
			o += "<Shots>" + shots + "</Shots>";
		if (wavy)
			o += "</Wavy>";
		//if (amplitude != 0)
			o += "<Amplitude>" + amplitude + "</Amplitude>";
		//if (frequency != 0)
			o += "<Frequency>" + frequency + "</Frequency>";
		//if (arc != 0)
			o += "<ArcGap>" + arc + "</ArcGap>";
		//if (projectileLifetime != 0)
			o += "<Lifetime>" + projectileLifetime + "</Lifetime>";
		//if (projectileSpeed != 0)
			o += "<Speed>" + projectileSpeed + "</Speed>";
		//if (!tooltip.equals(""))
			o += "<ToolTip>" + tooltip + "</ToolTip>";
		o += "<BagType>" + bagType + "</BagType>";
		
		o += "<MpCost>" + manaCost + "</MpCost>";
		
		o += "<Cooldown>" + cooldown + "</Cooldown>";
		
		if (!conditionEnemy.equals(""))
		{
			o += "<ConditionEnemy>" + conditionEnemy + "</ConditionEnemy>";
			//System.out.println(conditionEnemy + "\n\n");
		}
		
		o += "</Item>";
		
		while (o.contains("\n"))
		{
			o = o.substring(0, o.indexOf("\n")) + o.substring(o.indexOf("\n")+1, o.length());
		}
		/*
		String os = o;
		while (os.contains("\""))
		{
			o = o.substring(o.indexOf("\"")) + "\\" + o.substring(o.indexOf("\"")+1, o.length());
			os = o.substring(o.indexOf("\""), o.length());
		}
		os = o;
		
		while (o.contains("\'"))
		{
			o = o.substring(o.indexOf("\'")) + "\\" +  o.substring(o.indexOf("\'")+1, o.length());
			os = o.substring(o.indexOf("\'"), o.length());
		}*/
		
		//o += "\n";
		
		int fi = 0;
		while (o.indexOf("'", fi) != -1)
		{
			if (!Character.toString(o.charAt(o.indexOf("'", fi)-1)).equals("\\"))
			{
				o = o.substring(0, o.indexOf("'", fi)) + "\\'" + o.substring(o.indexOf("'", fi)+1, o.length());
				
			}
			fi = o.indexOf("'", fi) + 2;
		}
		
		return o;
	}
	
	public int getHp()
	{
		return hp;
	}
	public int getMp()
	{
		return mp;
	}
	public int getAtk()
	{
		return atk;
	}
	public int getSpd()
	{
		return spd;
	}
	public int getVit()
	{
		return vit;
	}
	public int getDef()
	{
		return def;
	}
	public int getDex()
	{
		return dex;
	}
	public int getWis()
	{
		return wis;
	}
	public int getFame()
	{
		return fame;
	}
	public int getBase()
	{
		return baseDamage;
	}
	public int getMax()
	{
		return maxDamage;
	}
	public int getRof()
	{
		return rof;
	}
	public int getShots()
	{
		return shots;
	}
	public double getArc()
	{
		return arc;
	}
	public int getSet()
	{
		return st;
	}
	public double getRange()
	{
		return range;
	}
	public double getAmplitude()
	{
		return amplitude;
	}
	public double getFrequency()
	{
		return frequency;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public String getEffect()
	{
		return effect;
	}
	public String getTier()
	{
		return tier;
	}
	public int getStat(int i)
	{
		if (i == 0)
		{
			return hp;
		}
		if (i == 1)
		{
			return mp;
		}
		if (i == 2)
		{
			return atk;
		}
		if (i == 3)
		{
			return spd;
		}
		if (i == 4)
		{
			return vit;
		}
		if (i == 5)
		{
			return def;
		}
		if (i == 6)
		{
			return dex;
		}
		else
		{
			return wis;
		}
	}
	
	public String getFilePath()
	{
		return filepath;
	}
	
	public String getSetName()
	{
		return setName;
	}
	
	public String toString()
	{
		return name;
	}
	
	public void setFilePath(String s)
	{
		filepath = s;
	}
	
	public void loadImage()
	{
		if (sprite == null)
		{
			try {
				sprite = ImageIO.read(new File(filepath));
			}
			catch (IOException e) {
				
			}
		}
	}
	
	public BufferedImage getImage()
	{
		return sprite;
	}
	
	public boolean isSoulbound()
	{
		return soulbound;
	}
	
	public void setDefIgnore(boolean b)
	{
		ignoresDefense = b;
	}
	
	public boolean isDefIgnore()
	{
		return ignoresDefense;
	}
	
	public void setMultiHit(boolean b)
	{
		multiHit = b;
	}
	
	public boolean isMultiHit()
	{
		return multiHit;
	}
	
	public int getSlotType()
	{
		return slotType;
	}
	
	public String getToolTip()
	{
		return tooltip;
	}
	
	public double getLifetime()
	{
		return projectileLifetime;
	}
	public double getProjSpeed()
	{
		return projectileSpeed;
	}
	
	public boolean isOutclassedBy(Equippable e)
	{
		if (!e.getToolTip().equals(tooltip) && !tooltip.equals(""))
			return false;
		
		if (e.getArc() != arc || e.getAmplitude() != amplitude ||
				e.getFrequency() != frequency)
			return false;
		
		if (e.getHp() < hp || e.getMp() < mp || e.getAtk() < atk ||
				e.getDef() < def || e.getSpd() < spd || 
				e.getDex() < dex || e.getVit() < vit ||
				e.getWis() < wis)
			return false;
		
		if (e.getTier().equals("ST"))
			return false;
		
		if (e.getShots() != shots)
			return false;
		
		if (e.isSoulbound() && !soulbound)
			return false;
		
		if (e.getBase() >= baseDamage && e.getMax() >= maxDamage &&
				e.getLifetime() >= projectileLifetime &&
				e.getProjSpeed() >= projectileSpeed &&
				(e.isMultiHit() || !multiHit) &&
				(e.isDefIgnore() || !ignoresDefense) &&
				e.getRof() >= rof)
		{
			if (e.getBase() == baseDamage && e.getMax() == maxDamage &&
					e.getLifetime() == projectileLifetime &&
					e.getProjSpeed() == projectileSpeed &&
					e.isMultiHit() == multiHit &&
					e.isDefIgnore() == ignoresDefense &&
					e.getRof() == rof)
			{
				return false;
			}
			else
				return true;
		}
		return false;
	}
	
	public boolean isPotentialDps()
	{
		if (atk > 0 || dex > 0 || wis > 0)
		{
			return true;
		}
		
		if (tier.equals("ST"))
		{
			return true;
		}
		
		if (!tooltip.equals(""))
		{
			return true;
		}
		
		return false;
	}
}
