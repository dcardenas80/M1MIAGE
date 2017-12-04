package fr.edu.istic.m1.miage.miniediteur.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCopyText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCutText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableDeleteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableInsertText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordablePasteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordablePlayRecording;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableSelectText;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

class RecorderTest {
	private Recorder recorder;
	private IHMImpl ihm;
	private EditorMotorImpl editorMotorImpl;

	@BeforeEach
	void init() {
		// Insert some sample data before each test

		try {
			Field instance = Recorder.class.getDeclaredField("recorderInstance");
			instance.setAccessible(true);
			instance.set(null, null);
			Field instanceIhm = IHMImpl.class.getDeclaredField("IHMImplInstance");
			instanceIhm.setAccessible(true);
			instanceIhm.set(null, null);
			Field instanceEditor = EditorMotorImpl.class.getDeclaredField("editorMotorImpl");
			instanceEditor.setAccessible(true);
			instanceEditor.set(null, null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void recordandPlayTestInsert() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihm = IHMImpl.getInstance();
		editorMotorImpl.attach(ihm);
		recorder = Recorder.getInstance();
		ihm.setCaretPosition(0);
		ihm.setLastChart('D');
		recorder.startRecording();
		RecordableInsertText insertText = new RecordableInsertText();
		insertText.execute();
		recorder.stopRecording();
		recorder.playRecording();

		assertAll("Assertion", () -> assertEquals(2, ihm.getCaretPosition()),
				() -> assertEquals("DD", editorMotorImpl.getBuffer()));

	}

	@Test
	void recordandPlaySelectCopyPasteTest() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihm = IHMImpl.getInstance();
		editorMotorImpl.attach(ihm);
		recorder = Recorder.getInstance();
		ihm.setCaretPosition(0);
		char[] character = { 't', 'e', 's', 't', ' ', 'p', 'a', 's', 't', 'e' };
		String resultText = "test pastetest pastetest paste";
		for (int i = 0; i < character.length; i++) {
			ihm.setCaretPosition(ihm.getCaretPosition());
			ihm.setLastChart(character[i]);
			RecordableInsertText insertText = new RecordableInsertText();
			insertText.execute();
		}

		recorder.startRecording();
		ihm.setSelectionOrigin(0);
		ihm.setSelectionSize(10);
		RecordableSelectText selectText = new RecordableSelectText();
		editorMotorImpl.setSelectionMacro(true);
		selectText.execute();
		RecordableCopyText copyText = new RecordableCopyText();
		copyText.execute();
		ihm.setCaretPosition(11);
		RecordablePasteText pasteText = new RecordablePasteText();
		pasteText.execute();
		recorder.stopRecording();
		recorder.playRecording();

		assertAll("Assertion", () -> assertEquals(30, ihm.getCaretPosition()),
				() -> assertEquals(resultText, editorMotorImpl.getBuffer()));

	}

	@Test
	void recordandPlaySelectCutPasteTest() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihm = IHMImpl.getInstance();
		editorMotorImpl.attach(ihm);
		recorder = Recorder.getInstance();
		ihm.setCaretPosition(0);
		char[] character = { 't', 'e', 's', 't', ' ', 'p', 'a', 's', 't', 'e' };
		String resultText = "test pastetest paste";
		for (int i = 0; i < character.length; i++) {
			ihm.setCaretPosition(ihm.getCaretPosition());
			ihm.setLastChart(character[i]);
			RecordableInsertText insertText = new RecordableInsertText();
			insertText.execute();
		}

		recorder.startRecording();
		ihm.setSelectionOrigin(0);
		ihm.setSelectionSize(10);
		RecordableSelectText selectText = new RecordableSelectText();
		editorMotorImpl.setSelectionMacro(true);
		selectText.execute();
		RecordableCutText cutText = new RecordableCutText();
		cutText.execute();
		ihm.setCaretPosition(11);
		RecordablePasteText pasteText = new RecordablePasteText();
		pasteText.execute();
		recorder.stopRecording();
		recorder.playRecording();

		assertAll("Assertion", () -> assertEquals(20, ihm.getCaretPosition()),
				() -> assertEquals(resultText, editorMotorImpl.getBuffer()));

	}

	@Test
	void undoInsertTest() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihm = IHMImpl.getInstance();
		editorMotorImpl.attach(ihm);
		recorder = Recorder.getInstance();
		ihm.setCaretPosition(0);
		char[] character = { 't', 'e', 's', 't', ' ', 'i', 'n', 's', 'e', 'r','t' };
		String resultText = "test ";
		for (int i = 0; i < character.length; i++) {
			ihm.setCaretPosition(ihm.getCaretPosition());
			ihm.setLastChart(character[i]);
			RecordableInsertText insertText = new RecordableInsertText();
			insertText.execute();
		}
		for (int i = 0; i < 6; i++) {
			recorder.undo();
		}
		assertAll("Assertion", () -> assertEquals(5, ihm.getCaretPosition()),
				() -> assertEquals(resultText, editorMotorImpl.getBuffer()));
	}
	
	@Test
	void redoDelete() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihm = IHMImpl.getInstance();
		editorMotorImpl.attach(ihm);
		recorder = Recorder.getInstance();
		ihm.setCaretPosition(0);
		char[] character = { 't', 'e', 's', 't', ' ', 'd','e','l','e','t','e' };
		String resultText = "test delet";
		for (int i = 0; i < character.length; i++) {
			ihm.setCaretPosition(ihm.getCaretPosition());
			ihm.setLastChart(character[i]);
			RecordableInsertText insertText = new RecordableInsertText();
			insertText.execute();
		}
		RecordableDeleteText deleteText = new RecordableDeleteText();
		deleteText.execute();
		recorder.undo();
		recorder.redo();
		assertAll("Assertion", () -> assertEquals(10, ihm.getCaretPosition()),
				() -> assertEquals(resultText, editorMotorImpl.getBuffer()));
	}
	
	@Test
	void undoMacro() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihm = IHMImpl.getInstance();
		editorMotorImpl.attach(ihm);
		recorder = Recorder.getInstance();
		ihm.setCaretPosition(0);
		char[] character = { 't', 'e', 's', 't', ' ', 'm', 'a', 'c', 'r', 'o' };
		String resultText = "test macro";
		recorder.startRecording();
		for (int i = 0; i < character.length; i++) {
			ihm.setCaretPosition(ihm.getCaretPosition());
			ihm.setLastChart(character[i]);
			RecordableInsertText insertText = new RecordableInsertText();
			insertText.execute();
		}
		recorder.stopRecording();
		ihm.setCaretPosition(11);
		RecordablePlayRecording playRecording = new RecordablePlayRecording();
		playRecording.execute();
		recorder.undo();
		assertAll("Assertion", () -> assertEquals(10, ihm.getCaretPosition()),
				() -> assertEquals(resultText, editorMotorImpl.getBuffer()));
	}
	@Test
	void redoMacro() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihm = IHMImpl.getInstance();
		editorMotorImpl.attach(ihm);
		recorder = Recorder.getInstance();
		ihm.setCaretPosition(0);
		char[] character = { 't', 'e', 's', 't', ' ', 'm', 'a', 'c', 'r', 'o' };
		String resultText = "test macrotest macro";
		recorder.startRecording();
		for (int i = 0; i < character.length; i++) {
			ihm.setCaretPosition(ihm.getCaretPosition());
			ihm.setLastChart(character[i]);
			RecordableInsertText insertText = new RecordableInsertText();
			insertText.execute();
		}
		recorder.stopRecording();
		ihm.setCaretPosition(11);
		RecordablePlayRecording playRecording = new RecordablePlayRecording();
		playRecording.execute();
		recorder.undo();
		recorder.redo();
		assertAll("Assertion", () -> assertEquals(20, ihm.getCaretPosition()),
				() -> assertEquals(resultText, editorMotorImpl.getBuffer()));
	}


}
