/**
 * 
 */
package com.xored.glance.internal.ui.sources;

import org.eclipse.swt.widgets.Control;

import com.xored.glance.ui.sources.ITextSource;
import com.xored.glance.ui.sources.ITextSourceDescriptor;

/**
 * @author Yuri Strot
 * 
 */
public class TextSourceMaker {

	public TextSourceMaker(ITextSourceDescriptor description, Control control) {
		this.description = description;
		this.control = control;
	}

	public boolean isValid() {
		return description == null ? false : description.isValid(control);
	}

	public ITextSource create() {
		return description == null ? null : description.createSource(control);
	}

	/**
	 * @return the control
	 */
	public Control getControl() {
		return control;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((control == null) ? 0 : control.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextSourceMaker other = (TextSourceMaker) obj;
		if (control == null) {
			if (other.control != null)
				return false;
		} else if (!control.equals(other.control))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	private ITextSourceDescriptor description;
	private Control control;

}
