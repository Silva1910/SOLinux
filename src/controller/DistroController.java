package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class DistroController {

	public static void exibeDistro() {
		

			String os = System.getProperty("os.name").toLowerCase();

			if (os.contains("nix")|| os.contains("nux")) {
				VersionUnix();
			}  else {
				JOptionPane.showMessageDialog(null, "Sistema operacional não suportado para esta aplicação.");
			}

		}
	
	private static void  VersionUnix() {
		try {
			String command = "cat /etc/issue";
            Process process = Runtime.getRuntime().exec(new String[] { "bash", "-c", command });

            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
