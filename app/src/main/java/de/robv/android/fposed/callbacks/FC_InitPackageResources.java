package de.robv.android.fposed.callbacks;

import android.content.res.XResources;

import de.robv.android.fposed.IFposedHookInitPackageResources;
import de.robv.android.fposed.FposedBridge.CopyOnWriteSortedSet;

/**
 * This class is only used for internal purposes, except for the {@link InitPackageResourcesParam}
 * subclass.
 */
public abstract class FC_InitPackageResources extends FCallback implements IFposedHookInitPackageResources {
	/**
	 * Creates a new callback with default priority.
	 * @hide
	 */
	@SuppressWarnings("deprecation")
	public FC_InitPackageResources() {
		super();
	}

	/**
	 * Creates a new callback with a specific priority.
	 *
	 * @param priority See {@link FCallback#priority}.
	 * @hide
	 */
	public FC_InitPackageResources(int priority) {
		super(priority);
	}

	/**
	 * Wraps information about the resources being initialized.
	 */
	public static final class InitPackageResourcesParam extends FCallback.Param {
		/** @hide */
		public InitPackageResourcesParam(CopyOnWriteSortedSet<FC_InitPackageResources> callbacks) {
			super(callbacks);
		}

		/** The name of the package for which resources are being loaded. */
		public String packageName;

		/**
		 * Reference to the resources that can be used for calls to
		 * {@link XResources#setReplacement(String, String, String, Object)}.
		 */
		public XResources res;
	}

	/** @hide */
	@Override
	protected void call(Param param) throws Throwable {
		if (param instanceof InitPackageResourcesParam)
			handleInitPackageResources((InitPackageResourcesParam) param);
	}
}
