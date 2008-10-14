package org.opendds.jms;

import javax.jms.MessageNotWriteableException;
import javax.jms.MessageNotReadableException;

/**
 * Message body state where the message is not writable, but readable.
 * A freshly receiveed TextMessage, ObjectMessage and MapMessage that is in this state.
 */
public class MessageStateBodyNonWritable implements MessageState {
    private AbstractMessageImpl message;

    public MessageStateBodyNonWritable(AbstractMessageImpl message) {
        this.message = message;
    }

    public void checkReadable() throws MessageNotReadableException {
        // No-op
    }

    public void checkWritable() throws MessageNotWriteableException {
        throw new MessageNotWriteableException("The message is in a body non-writable state");
    }

    public void makeReadable() {
        // No-op
    }

    public void makeWritable() {
        message.setBodyState(new MessageStateWritable());
    }
}