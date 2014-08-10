package io.github.sidney3172.doc.client.start;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GettingStartedView extends Composite{

	private static GettingStartedViewUiBinder uiBinder = GWT
			.create(GettingStartedViewUiBinder.class);

	interface GettingStartedViewUiBinder extends
			UiBinder<Widget, GettingStartedView> {
	}

    @UiField
    TextAreaElement dependencyCode;
    @UiField
    TextAreaElement inheritCode;

	public GettingStartedView() {
		initWidget(uiBinder.createAndBindUi(this));
        StringBuilder builder = new StringBuilder();
        builder.append("<dependency>\n");
        builder.append("\t<groupId>io.github.sidney3172</groupId>\n");
        builder.append("\t <artifactId>gwt-chartjs</artifactId>\n");
        builder.append("\t <version>0.1.1</version>\n");
        builder.append("<dependency>");

        dependencyCode.setInnerText(builder.toString());

        inheritCode.setInnerText("<inherits name=\"io.github.sidney3172.ChartJs\"/>");
	}
}
