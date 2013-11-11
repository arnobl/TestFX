package org.loadui.testfx.matchers;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

import static org.loadui.testfx.GuiTest.find;

public class HasLabelStringMatcher extends TypeSafeMatcher<Object>
{
	private final String label;

	public HasLabelStringMatcher( String label )
	{
		this.label = label;
	}

	public void describeTo( Description desc )
	{
		desc.appendText( "Node should have label " + label );
	}

	@Override
	public boolean matchesSafely( Object target )
	{
		if( target instanceof String )
		{
			return nodeHasLabel( find( (String) target ) );
		} else if( target instanceof Labeled )
		{
			return nodeHasLabel( (Labeled) target );
		}
		return false;
	}

	private boolean nodeHasLabel( Node node )
	{
		Labeled labeled = (Labeled) node;
		return label.equals( labeled.getText() );
	}
}