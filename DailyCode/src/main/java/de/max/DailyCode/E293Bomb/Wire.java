package de.max.DailyCode.E293Bomb;

public class Wire implements Cable{

	private boolean cut = false;
	private boolean doNotCut = false;
	
	@Override
	public boolean cut()
	{
		if (doNotCut)
		{
			// wire was cut and no other one allowed ==> boom
			return false;
		}
		this.cut = true;
		// the cut was successful
		return true;
	}

	@Override
	public void doNotCut()
	{
		this.doNotCut = true;		
	}
}