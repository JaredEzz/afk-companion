package com.jaka.afkcompanion.watch;

/**
 * Decides when the cannonball count is worth a warning: once on the way down past the
 * threshold, and again after any top-up, the same way the core Cannon plugin does it.
 */
public class CannonWarning
{
	private int lastCount;
	private boolean warned;

	/**
	 * @param count cannonballs loaded in the cannon now
	 * @param threshold warn at or below this many; 0 disables the warning
	 * @return true when a warning should go out
	 */
	public boolean update(int count, int threshold)
	{
		if (count > lastCount)
		{
			warned = false;
		}
		lastCount = count;

		if (threshold <= 0 || count <= 0 || count > threshold || warned)
		{
			return false;
		}

		warned = true;
		return true;
	}

	public void reset()
	{
		lastCount = 0;
		warned = false;
	}
}
