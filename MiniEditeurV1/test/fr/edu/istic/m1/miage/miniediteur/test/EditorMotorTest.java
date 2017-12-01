package fr.edu.istic.m1.miage.miniediteur.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

@RunWith(JUnitPlatform.class)
class EditorMotorTest {
	EditorMotor editorMotor;

	/**
	 * it is needed because the editorMotor Class has to make the test but this class has a lazy
	 * singleton pattern it is necessary to use Reflection to set the instance as
	 * null with that the current test being played will not be affected with the
	 * results from the previous text
	 */
	@BeforeEach
	void init() {
		// Insert some sample data before each test
		editorMotor = EditorMotorImpl.getInstance();
		try {
			Field instance = EditorMotorImpl.class.getDeclaredField("editorMotorImpl");

			instance.setAccessible(true);
			instance.set(null, null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This test checks the text insertion on the Editor's motor
	 */
	@Test
	void appendTextTest() {
		char[] character = { 'q', '\n', 's', 'd', '3' };
		String stringFromCharacters = new String(character);
		for (int i = 0; i < character.length; i++) {
			editorMotor.insertText(character[i]);
		}
		assertEquals(stringFromCharacters, editorMotor.getBuffer());
	}

	/**
	 * This test checks the cases when the buffer is null and the user tries types
	 * backspace
	 */
	@Test
	void deleteText() {

		int length = 1;
		String stringFromCharacters = "";
		editorMotor.setCaret(editorMotor.getBuffer().length());
		while (length > 0) {
			editorMotor.deleteText();
			length--;
		}
		stringFromCharacters = stringFromCharacters.substring(0, editorMotor.getBuffer().length());
		assertEquals(stringFromCharacters, editorMotor.getBuffer());
	}

	/**
	 * This test checks the selection of text on the Editor's buffer, the copy of
	 * that selection and finally the paste of the content on the cliboard on the
	 * buffer
	 */
	@Test
	void selectCopyPaste() {
		char[] character = { 'q', '\n', 's', 'd', '3' };
		String stringFromCharacters = new String(character);
		stringFromCharacters = stringFromCharacters
				+ stringFromCharacters.substring(0, stringFromCharacters.length() - 1);
		for (int i = 0; i < character.length; i++) {
			editorMotor.insertText(character[i]);
		}

		editorMotor.setSelection(0, 4);
		editorMotor.copyText();
		editorMotor.setCaret(5);
		try {
			editorMotor.pasteText();
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(stringFromCharacters, editorMotor.getBuffer());
	}

	@Test
	void setSelection() {
		editorMotor.getBuffer();
		char[] character = { 'q', '\n', 's', 'd', '3' };

		for (int i = 0; i < character.length; i++) {
			editorMotor.insertText(character[i]);
		}

		editorMotor.setSelection(0, 4);
		assertAll("Assertion", () -> assertTrue(0 == editorMotor.getSelectionOrigin()),
				() -> assertTrue(4 == editorMotor.getSelectionSize()));
	}
	
	/**
	 * This test checks the deletion of a selection of characters
	 *
	 */
	@Test
	void deleteTextByWords() {
		char[] character = { 't', 'e', 's', 't', ' ','d','e','l','e','t','e' };
		String stringFromCharacters = "test";
		for (int i = 0; i < character.length; i++) {
			editorMotor.insertText(character[i]);
		}
	
		editorMotor.setSelection(4, 10);
		
			editorMotor.deleteText();

		assertEquals(stringFromCharacters, editorMotor.getBuffer());
	}

	@Test
	void deleteTextByChar() {
		char[] character = { 't', 'e', 's', 't', ' ','d','e','l','e','t','e' };
		String stringFromCharacters = "test delet";
		for (int i = 0; i < character.length; i++) {
			editorMotor.insertText(character[i]);
		}
	
		
			editorMotor.deleteText();

		assertEquals(stringFromCharacters, editorMotor.getBuffer());
	}

}
