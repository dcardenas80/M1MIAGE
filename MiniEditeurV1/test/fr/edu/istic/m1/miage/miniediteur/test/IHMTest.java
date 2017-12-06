package fr.edu.istic.m1.miage.miniediteur.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import javax.swing.event.CaretEvent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import fr.edu.istic.m1.miage.miniediteur.client.Client;
import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.command.CopyText;
import fr.edu.istic.m1.miage.miniediteur.command.DeleteText;
import fr.edu.istic.m1.miage.miniediteur.command.InsertText;
import fr.edu.istic.m1.miage.miniediteur.command.PasteText;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

class IHMTest {
	IHM ihm;
	Client client;
	EditorMotor editorMotor;
	
	/**
	 * This method is call before each execution of each test, the IHMImpl class use
	 * a lazy singleton pattern that affects the outcome of unit test, that's why
	 * the use of Reflection is needed to leave the only instance of that class in a
	 * new like state
	 */
	@BeforeEach
	void init() {
		client =mock(Client.class);
		ihm = IHMImpl.getInstance();
		editorMotor = EditorMotorImpl.getInstance();
	}

	@Test
	void InsertTest() {
		editorMotor.attach(ihm);
		ihm.setLastChart('a');
		Command insertText = new InsertText();
		insertText.execute();
		assertEquals(1, ihm.getCaretPosition());
	}

	@Test
	void deleteText() {
		editorMotor.attach(ihm);
		ihm.setLastChart('a');
		Command insertText = new InsertText();
		insertText.execute();
		ihm.setLastChart('\b');
		Command deleteText = new DeleteText();
		deleteText.execute();
		assertEquals(0, ihm.getCaretPosition());
	}

//	@Test
//	void pasteText() {
//		editorMotor.attach(ihm);
//		char[] character = { 'p', 'a', 's', 't', 'e' };
//		for (int i = 0; i < character.length; i++) {
//			ihm.setLastChart(character[i]);
//			Command insertText = new InsertText();
//			insertText.execute();
//		}
//		CaretEvent e = null;
//		doNothing().when(client).caretUpdate(e);
//		//editorMotor.setSelection(0, 5);
//
//		
//		Command copyText = new CopyText();
//		copyText.execute();
//		Command pasteText = new PasteText();
//		pasteText.execute();
//		assertEquals(11, ihm.getCaretPosition());
//	}

	@AfterEach
	void reset() {

		try {
			Field instance = IHMImpl.class.getDeclaredField("IHMImplInstance");

			instance.setAccessible(true);
			instance.set(null, null);
			Field instanceEditor = EditorMotorImpl.class.getDeclaredField("editorMotorImpl");
			instanceEditor.setAccessible(true);
			instanceEditor.set(null, null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
