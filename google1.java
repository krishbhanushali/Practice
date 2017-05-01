import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class google1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
		List<Directory> directories = new ArrayList<Directory>();
		List<File> files = new ArrayList<File>();
		List<String> allPaths = new ArrayList<String>();
		int lastStop = 0;
		int numberOfSpaces = 0;
		nextLine += "@!#";
		for(int i = lastStop; i < nextLine.length()-2; i ++){
			String temp = nextLine;
			if(temp.substring(i,i+2).contains("\\n") || temp.substring(i,i+3).contains("@!#")){
				String eachString = temp.substring(lastStop,i);
				String temp1= eachString;
				numberOfSpaces = eachString.length() - eachString.replace(" ","").length();
				lastStop = i+2;
				
				if(temp1.contains("dir")){
					Directory d = null;
					if(numberOfSpaces>0){
						for(int j = directories.size()-1;j>=0;j--){
							if(directories.get(j).getLevel()==numberOfSpaces-1){
								d = directories.get(j);
								break;
							}
						}
					}
					Directory directory = new Directory(temp1.trim(),numberOfSpaces,d);
					//System.out.println(directory.directoryName+" is created with level "+numberOfSpaces);
					directories.add(directory);
				}
				if(temp1.contains(".png") || temp1.contains(".jpeg") || temp1.contains(".gif")){
					Directory d = null;
					for(int j = directories.size()-1;j>=0;j--){
						if(directories.get(j).getLevel()==numberOfSpaces-1){
							d = directories.get(j);
							break;
						}
					}
					File file = new File(temp1.trim(),d);
					files.add(file);
					//System.out.println(file.getFileName()+" is created for directory "+d.getDirectoryName()+".");
				}
				if(temp1.contains(".jpeg") || temp1.contains(".png") || temp1.contains(".gif")){
					String path = "";
					for(File file:files){
						if(file.getFileName().equals(temp1.trim())){
							Directory parent = file.getDirectory();
							path = "/"+parent.getDirectoryName();
							while(parent.getParentDirectory()!=null){
								path = "/"+parent.getParentDirectory().getDirectoryName()+path;
								parent = parent.getParentDirectory();
							}
						}
					}
					allPaths.add(path);
				}
				
			}
			
		}
		String path = allPaths.get(0);
		int max = path.length();
		for(String s : allPaths){
			if(s.length()>max){
				max = s.length();
			}
		}
		System.out.println(max);
		
		scanner.close();
	}
}


class Directory{
	String directoryName;
	int level;
	Directory parentDirectory;
	Directory(){};
	public Directory(String directoryName, int level, Directory parentDirectory) {
		
		this.directoryName = directoryName;
		this.level = level;
		this.parentDirectory = parentDirectory;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	public Directory getParentDirectory() {
		return parentDirectory;
	}
	public void setParentDirectory(Directory parentDirectory) {
		this.parentDirectory = parentDirectory;
	}
	
}

class File{
	String fileName;
	Directory directory;
	
	public File(String fileName, Directory directory) {
		super();
		this.fileName = fileName;
		this.directory = directory;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Directory getDirectory() {
		return directory;
	}
	public void setDirectory(Directory directory) {
		this.directory = directory;
	}
	
}