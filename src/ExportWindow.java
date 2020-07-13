import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ExportWindow extends JFrame{

	JTextArea label;
	JTextArea area = new JTextArea("");
	JPanel leftP = new JPanel();
	JPanel rightP = new JPanel();
	JPanel topP = new JPanel();
	JPanel bottomP = new JPanel();
	JButton generate = new JButton("Generer");
	JPanel centerP = new JPanel();
	public ExportWindow() {
		
		setSize(800,800);
		setTitle("Generer code HTML");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		label = new JTextArea("Pour pouvoir utiliser ce formulaire, veuillez visiter https://console.firebase.google.com et créer un projet, ouvrez le, cliquez sur ajouter une application et copiez le code html dans la zone de texte si dessous ");

		label.setEditable(false);
		label.setLineWrap(true);
		
		label.setPreferredSize(new Dimension(690,150));
		area.setPreferredSize(new Dimension(692,500));
	
		area.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 1, 1,1, new Color(209,211,226)) ,BorderFactory.createMatteBorder(15, 15, 15,15, Color.white) ));
		
		leftP.setPreferredSize(new Dimension(50,800));
		rightP.setPreferredSize(new Dimension(50,800));
		topP.setPreferredSize(new Dimension(800,50));
		bottomP.setPreferredSize(new Dimension(800,50));
		generate.setPreferredSize(new Dimension(700,30));
		
		centerP.add(label);
		centerP.add(area);
		add(centerP);
		add(topP,BorderLayout.NORTH);
		add(leftP,BorderLayout.WEST);
		add(rightP,BorderLayout.EAST);
		add(bottomP,BorderLayout.SOUTH);
		bottomP.add(generate);
		setVisible(true);
		
		generate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				generateForm();
				
			}
		});
		
	}
	void generateForm() {

		

	

				JFileChooser  chooser = new JFileChooser(); 
				chooser.setCurrentDirectory(new java.io.File("."));
			
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				 if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 



				String destDir =chooser.getCurrentDirectory().getAbsolutePath();

				InputStream is = getClass().getResourceAsStream("Resources/HTML_TEMPLATE.zip");
		
				ZipInputStream zis = new ZipInputStream(is);

				byte[] buffer = new byte[1024];

				String html = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "\r\n" + "<head>\r\n" + "\r\n"
						+ "  <meta charset=\"utf-8\">\r\n"
						+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
						+ "  <meta name=\"description\" content=\"\">\r\n" + "  <meta name=\"author\" content=\"\">\r\n"
						+ "\r\n" + "  <title>" + Formulaire.formName + "</title>\r\n" + "\r\n"
						+ "  <!-- Custom fonts for this template -->\r\n"
						+ "  <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n"
						+ "  <link\r\n"
						+ "    href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"\r\n"
						+ "    rel=\"stylesheet\">\r\n" + "\r\n" + "  <!-- Custom styles for this template -->\r\n"
						+ "  <link href=\"css/sb-admin-2.css\" rel=\"stylesheet\">\r\n" + "\r\n"
						+ "  <!-- Custom styles for this page -->\r\n"
						+ "  <link href=\"vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">\r\n"
						+ "\r\n" + "</head>\r\n" + "\r\n" + "<body id=\"page-top\">\r\n" + "\r\n"
						+ "  <!-- Page Wrapper -->\r\n" + "  <div id=\"wrapper\">\r\n" + "\r\n" + "\r\n"
						+ "        <!-- Begin Page Content -->\r\n"
						+ "        <div class=\"container-fluid\" style=\"margin-top:20px\">\r\n" + "\r\n"
						+ "          <!-- Page Heading -->\r\n" + " <!-- \r\n"
						+ "          <div class=\"d-sm-flex align-items-center justify-content-between mb-4\">\r\n"
						+ "            <h1 class=\"h3 mb-0 text-gray-800\">Builder</h1>\r\n"
						+ "            <a href=\"#\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\"><i class=\"fab fa-html5\"></i>\r\n"
						+ "              Generate</a>\r\n" + "          </div>-->\r\n" + "\r\n"
						+ "          <!-- FormBuilder Example -->\r\n" + "\r\n"
						+ "          <div class=\"card shadow mb-4 border-left-primary\" id=\"FormHeader\">\r\n"
						+ "            <div class=\"card-header py-3 d-sm-flex align-items-center justify-content-between mb-4\">\r\n"
						+ "              <h4 class=\"m-0 font-weight-bold text-primary\">" + Formulaire.formName + "</h4>\r\n"
						+ "            </div>\r\n" + "            <div class=\"card-body\">\r\n" + "\r\n"
						+ "              <p>" + FormElement.DF.getText() + "</p>\r\n" + "\r\n"
						+ "            </div>\r\n" + "\r\n" + "          </div>\r\n" + "\r\n"
						+ "          <Form id=\"Form\">\r\n" + "            <div id=\"Sections\">\n";

				for (FormElement fe: Interface.addedItemsVector) {
					html += fe.getHtmlCode();
				}

				html += " </div>\r\n" + "     \r\n" + "\r\n"
						+ "          <button type=\"submit\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\"\r\n"
						+ "          style=\"float:right; \"><i class=\"fas fa-check\" style=\"margin-right:5px\"></i> Submit</button>\r\n"
						+ "\r\n"
						+ "          <button type=\"reset\" class=\"d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm\"\r\n"
						+ "            style=\"float:right; margin-right:10px\"><i class=\"fas fa-trash-alt\" style=\"margin-right:5px\"></i> Reset</button>\r\n"
						+ "\r\n" + "        </Form>\r\n" + "\r\n" + "        </div>\r\n"
						+ "        <!-- /.container-fluid -->\r\n" + "\r\n" + "      </div>\r\n"
						+ "      <!-- End of Main Content -->\r\n" + "\r\n" + "    </div>\r\n"
						+ "    <!-- End of Content Wrapper -->\r\n" + "\r\n" + "  </div>\r\n"
						+ "  <!-- End of Page Wrapper -->\r\n" + "\r\n" + "  <!-- Scroll to Top Button-->\r\n"
						+ "  <a class=\"scroll-to-top rounded\" href=\"#page-top\">\r\n"
						+ "    <i class=\"fas fa-angle-up\"></i>\r\n" + "  </a>\r\n" + "\r\n"
						+ "  <!-- Logout Modal-->\r\n"
						+ "  <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\r\n"
						+ "    aria-hidden=\"true\">\r\n" + "    <div class=\"modal-dialog\" role=\"document\">\r\n"
						+ "      <div class=\"modal-content\">\r\n" + "        <div class=\"modal-header\">\r\n"
						+ "          <h5 class=\"modal-title\" id=\"exampleModalLabel\">Ready to Leave?</h5>\r\n"
						+ "          <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n"
						+ "            <span aria-hidden=\"true\">×</span>\r\n" + "          </button>\r\n"
						+ "        </div>\r\n"
						+ "        <div class=\"modal-body\">Select \"Logout\" below if you are ready to end your current session.</div>\r\n"
						+ "        <div class=\"modal-footer\">\r\n"
						+ "          <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancel</button>\r\n"
						+ "          <a class=\"btn btn-primary\" href=\"login.html\">Logout</a>\r\n"
						+ "        </div>\r\n" + "      </div>\r\n" + "    </div>\r\n" + "  </div>\r\n" + "\r\n"
						+ "  <script defer src=\"https://use.fontawesome.com/releases/v5.8.1/js/all.js\"\r\n"
						+ "    integrity=\"sha384-g5uSoOSBd7KkhAMlnQILrecXvzst9TdC09/VM+pjDTCM+1il8RHz5fKANTFFb+gQ\"\r\n"
						+ "    crossorigin=\"anonymous\"></script>\r\n" + "  <!-- Bootstrap core JavaScript-->\r\n"
						+ "  <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n"
						+ "  <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n" + "\r\n"
						+ "  <!-- Core plugin JavaScript-->\r\n"
						+ "  <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n" + "\r\n"
						+ "  <!-- Custom scripts for all pages-->\r\n"
						+ "  <script src=\"js/sb-admin-2.min.js\"></script>\r\n" + "\r\n"
						+ "  <!-- Page level plugins -->\r\n"
						+ "  <script src=\"vendor/datatables/jquery.dataTables.min.js\"></script>\r\n"
						+ "  <script src=\"vendor/datatables/dataTables.bootstrap4.min.js\"></script>\r\n" + " \r\n"
						+ "<script src=\"https://www.gstatic.com/firebasejs/5.11.0/firebase.js\"></script>"
						+ "<script src=\"js/database.js\"></script>" + "</body>\r\n" + "\r\n" + "</html>";


				File htmlFile;
				double bytesRead = 0;
				try {
					ZipEntry ze = zis.getNextEntry();
					while (ze != null) {
						String fileName = ze.getName();
						File newFile = new File(destDir + File.separator + fileName);

						bytesRead++;
						// pi.setProgress(bytesRead / 1778);
						System.out.println(bytesRead / 1778 + "%");

						// create all non exists folders
						// else you will hit FileNotFoundException for compressed folder
						if (ze.isDirectory()) {
							newFile.mkdirs();
						} else {
							FileOutputStream fos = new FileOutputStream(newFile);

							int len;
							while ((len = zis.read(buffer)) > 0) {
								fos.write(buffer, 0, len);
							}

							fos.close();
						}
						ze = zis.getNextEntry();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
				String db = area.getText() + "\n";
				
				db += "\r\n" + "firebase.initializeApp(config);\r\n" + "\r\n" + "// Reference messages\r\n"
						+ "var msgRef = firebase.database().ref('Messages');\r\n" + "\r\n" + "\r\n"
						+ "document.getElementById('Form').addEventListener('submit', submitForm);\r\n" + "\r\n"
						+ "function submitForm(e) {\r\n" + "\r\n" + "    e.preventDefault();\r\n"
						+ "    console.log(\"s\");\r\n"
						+ "    var allInputs = document.getElementById('Form').getElementsByTagName('Input');\r\n"
						+ "    var allTextAreas = document.getElementById('Form').getElementsByTagName('TextArea');\r\n"
						+ "    var allSelectInputs = document.getElementById('Form').getElementsByTagName('select');\r\n"
						+ "\r\n" + "\r\n" + "    var data = {};\r\n" + "\r\n"
						+ "    for (var i = 0; i < allInputs.length; i++) {\r\n"
						+ "        if (allInputs[i].getAttribute('type') == 'radio') {\r\n"
						+ "            if (allInputs[i].checked)\r\n"
						+ "                data[allInputs[i].getAttribute('name')] = allInputs[i].value;\r\n"
						+ "        } else if (allInputs[i].getAttribute('type') == 'checkbox') {\r\n"
						+ "            if (allInputs[i].checked)\r\n"
						+ "                data[allInputs[i].getAttribute('name')] = allInputs[i].value;\r\n"
						+ "        } else\r\n"
						+ "            data[allInputs[i].getAttribute('name')] = allInputs[i].value;\r\n" + "    }\r\n"
						+ "\r\n" + "    for (var i = 0; i < allTextAreas.length; i++) {\r\n"
						+ "        data[allTextAreas[i].getAttribute('name')] = allTextAreas[i].value;\r\n"
						+ "    }\r\n" + "\r\n" + "    for (var i = 0; i < allSelectInputs.length; i++) {\r\n"
						+ "        data[allSelectInputs[i].getAttribute('name')] = allSelectInputs[i].value;\r\n"
						+ "    }\r\n" + "\r\n" + "\r\n" + "    console.log(data);\r\n" +

						"\r\n" + "    saveMsg(data);\r\n" + "\r\n" + "    document.getElementById('Form').reset();\r\n"
						+ "\r\n" + "}\r\n" + "\r\n" + "function getInputValue(id) {\r\n"
						+ "    return document.getElementById(id).value;\r\n" + "}\r\n" + "\r\n" + "\r\n"
						+ "function saveMsg(data) {\r\n" + "\r\n" + "    var newMsgRef = msgRef.push();\r\n" + "\r\n"
						+ "    newMsgRef.set(data);\r\n" + "\r\n" + "}\r\n" + "\r\n" + "";
				String rb = area.getText() + "\n";

				rb += "firebase.initializeApp(config);\r\n" + "\r\n" + "\r\n"
						+ "var head = document.getElementById('head');\r\n"
						+ "var content = document.getElementById('tableContent');\r\n" + "\r\n" + "\r\n"
						+ "var userDataRef = firebase.database().ref(\"Messages\");\r\n"
						+ "console.log(firebase.database());\r\n"
						+ "var ref = firebase.database().ref(\"Messages\");\r\n" + "\r\n" + "var keys = [];\r\n"
						+ "var tableData = [];\r\n" + "var columns = [];\r\n" + "\r\n" + "\r\n"
						+ "userDataRef.on('value', function (snapshot) {\r\n" + "\r\n" + "    keys = [];\r\n"
						+ "    console.log(snapshot.exists());\r\n" + "    if (snapshot.exists()) {\r\n" + "\r\n"
						+ "        document.getElementById('Alert').style.display = \"none\";\r\n" + "\r\n" + "\r\n"
						+ "        content.innerHTML = \"\";\r\n" + "\r\n" + "\r\n" + "        var index = 1;\r\n"
						+ "\r\n" + "        snapshot.forEach(function (childSnapshot) {\r\n"
						+ "            var key = childSnapshot.key;\r\n" + "            keys.push(key);\r\n"
						+ "            var childData = childSnapshot.val();\r\n" + "\r\n"
						+ "            var row = [];\r\n" + "            row.push(index);\r\n"
						+ "            columns = [];\r\n" + "            columns.push({ title: 'ID' });\r\n" + "\r\n"
						+ "            var tr = document.createElement(\"TR\");\r\n" + "\r\n"
						+ "            var idTd = document.createElement(\"TD\");\r\n"
						+ "            idTd.innerText = index.toString();\r\n" + "\r\n"
						+ "            tr.appendChild(idTd);\r\n" + "\r\n"
						+ "            for (var key in childData) {\r\n" + "\r\n"
						+ "                columns.push({ title: key });\r\n"
						+ "                row.push(childData[key]);\r\n" + "\r\n" + "            }\r\n"
						+ "            index++;\r\n" + "            tableData.push(row);\r\n" + "     \r\n" + "\r\n"
						+ "\r\n" + "        });\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "    }else{\r\n"
						+ "        document.getElementById('Form').style.display = \"none\";\r\n" + "\r\n"
						+ "        document.getElementById('Alert').style.display = \"\";\r\n" + "    }\r\n" + "\r\n"
						+ "\r\n" + "     $('#dataTable').DataTable({\r\n" + "        data: tableData,\r\n"
						+ "        columns: columns\r\n" + "    });\r\n" + "});\r\n" + "\r\n" + "\r\n" + "";

				

					htmlFile = new File(destDir + "/index.html");
					File dbf = new File(destDir + "/js/database.js");
					File rdf = new File(destDir + "/js/ReadData.js");
					OutputStream os = null;
					try {
						os = new FileOutputStream(htmlFile);
						os.write(html.getBytes(), 0, html.length());

					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {

							os.close();
							Desktop.getDesktop().browse(htmlFile.toURI());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					try {
						os = new FileOutputStream(dbf);
						os.write(db.getBytes(), 0, db.length());

					} catch (IOException e) {
						e.printStackTrace();
					} finally {

					}
					
					try {
						os = new FileOutputStream(rdf);
						os.write(rb.getBytes(), 0, rb.length());

					} catch (IOException e) {
						e.printStackTrace();
					} finally {

					}

				
			     }
				 
					

	}

}
