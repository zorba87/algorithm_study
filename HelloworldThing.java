package hblee;
import org.slf4j.Logger;
import com.thingworx.data.util.InfoTableInstanceFactory;
import com.thingworx.logging.LogUtilities;
import com.thingworx.metadata.annotations.ThingworxEventDefinition;
import com.thingworx.metadata.annotations.ThingworxEventDefinitions;
import com.thingworx.metadata.annotations.ThingworxPropertyDefinition;
import com.thingworx.metadata.annotations.ThingworxPropertyDefinitions;
import com.thingworx.metadata.annotations.ThingworxServiceDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceParameter;
import com.thingworx.metadata.annotations.ThingworxServiceResult;
import com.thingworx.things.Thing;
import com.thingworx.things.events.ThingworxEvent;
import com.thingworx.types.InfoTable;
import com.thingworx.types.collections.ValueCollection;
import com.thingworx.types.primitives.NumberPrimitive;
import com.thingworx.types.primitives.StringPrimitive;
import com.thingworx.webservices.context.ThreadLocalContext;

@ThingworxPropertyDefinitions(properties = {
		@ThingworxPropertyDefinition(name = "StringProperty1", description = "Sample string property", baseType = "STRING", aspects = {
				"isPersistent:false", "isReadOnly:false" }),
		@ThingworxPropertyDefinition(name = "NumberProperty1", description = "Sample number property", baseType = "NUMBER", aspects = {
				"isPersistent:false", "isReadOnly:false" }) })

@ThingworxEventDefinitions(events = {
		@ThingworxEventDefinition(name = "SalutationSent", description = "Salutation sent event", dataShape = "SalutationSentEvent") })
public class HelloWorldThing extends Thing {
	protected static Logger _logger = LogUtilities.getInstance().getApplicationLogger(HelloWorldThing.class);
	// local property values
	private String _stringProperty1 = "";
	private Double _numberProperty1 = 0.0;

	protected void initializeThing() throws Exception {
		_stringProperty1 = ((StringPrimitive) this.getPropertyValue("StringProperty1")).getValue();
		_numberProperty1 = ((NumberPrimitive) this.getPropertyValue("NumberProperty1")).getValue();
	}

	@ThingworxServiceDefinition(name = "SayHello", description = "Hello world")
	@ThingworxServiceResult(name = "Result", description = "Result", baseType = "STRING")
	public String SayHello() throws Exception {
		return "Hello world.";
	}

	@ThingworxServiceDefinition(name = "Greeting", description = "Hello world")
	@ThingworxServiceResult(name = "Result", description = "Result", baseType = "STRING")
	public String Greeting(
			@ThingworxServiceParameter(name = "userToGreet", description = "The user you're greeting", baseType = "USERNAME") String userToGreet)
			throws Exception {
		fireSalutationSentEvent(userToGreet);
		return "Hello " + userToGreet + ". How are you?";
	}

	// Event Firing Example
	private void fireSalutationSentEvent(String userName) throws Exception {
		ThingworxEvent event = new ThingworxEvent();
		event.setTraceActive(ThreadLocalContext.isTraceActive());
		event.setSecurityContext(ThreadLocalContext.getSecurityContext());
		event.setSource(getName());
		event.setEventName("SalutationSent");
		// the name parameter isn't really used
		InfoTable data = InfoTableInstanceFactory.createInfoTableFromDataShape("SalutationSentEvent");
		ValueCollection values = new ValueCollection();
		values.put("userGreeted", new StringPrimitive(userName));
		data.addRow(values);
		event.setEventData(data);
		this.dispatchBackgroundEvent(event);
	}
}