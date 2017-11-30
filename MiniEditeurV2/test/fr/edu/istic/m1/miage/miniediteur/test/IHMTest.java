package fr.edu.istic.m1.miage.miniediteur.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.edu.istic.m1.miage.miniediteur.client.Client;
import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.command.InsertText;
import fr.edu.istic.m1.miage.miniediteur.command.SelectText;
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
		client = Client.getInstance();
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
	/**
	 * this will always fall because there is not
	 */
	@Test
	void setSelection() {
		editorMotor.attach(ihm);
		char[] character = { 't', 'e', 's', 't', ' ','s','e','l','e','c','t' };
		Command insertText = new InsertText();
		for (int i = 0; i < character.length; i++) {
			ihm.setLastChart(character[i]);
			insertText.execute();
		}
		ihm.setSelectionOrigin(5);
		ihm.setSelectionSize(5);
		SelectText selectText = new SelectText();
		selectText.execute();
		assertAll("Selection Assertion", () -> assertTrue(5 == editorMotor.getSelectionOrigin()),
				() -> assertTrue(10-5 == editorMotor.getSelectionSize()));
	
	}
	
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
