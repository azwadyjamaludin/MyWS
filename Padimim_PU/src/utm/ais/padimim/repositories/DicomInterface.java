package utm.ais.padimim.repositories;

import java.io.File;
import java.io.IOException;

public interface DicomInterface {
	void uploadFile(String filename, File newfile) throws IOException;
}
