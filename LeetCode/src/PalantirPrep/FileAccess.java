package PalantirPrep;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

class FolderProp {
    int id;
    HashSet<String> userAccess;
    FolderProp parentFolder;
    ArrayList<FolderProp> subFolders;
    public FolderProp(int id){
        this.id = id;
        this.userAccess = new HashSet<>();
        this.parentFolder = null;
        this.subFolders = new ArrayList<>();
    }

    public FolderProp(int id, FolderProp parent){
        this.id = id;
        this.userAccess = new HashSet<>();
        this.parentFolder = parent;
        parent.subFolders.add(this);
        this.subFolders = new ArrayList<>();
    }

}


public class FileAccess {

    public static void main(String[] args) {
        // initialize folders
        FolderProp root = new FolderProp(0);
        FolderProp f1 = new FolderProp(1, root);
        FolderProp f2 = new FolderProp(2, root);
        FolderProp f3 = new FolderProp(3, f1);
        FolderProp f4 = new FolderProp(4, f2);
        FolderProp f5 = new FolderProp(5, f2);
        FolderProp f6 = new FolderProp(6, f5);
        FolderProp f7 = new FolderProp(7, f6);
        FolderProp f8 = new FolderProp(8, f7);
        // give user access rights
        root.userAccess.add("root");
        f1.userAccess.add("u1");
        f2.userAccess.add("u2");
        f3.userAccess.add("u3");
        f4.userAccess.add("u4");
        f5.userAccess.add("u5");
        f6.userAccess.add("u6");
        f7.userAccess.add("u7");
        f8.userAccess.add("u8");

        //Given the fact that each access can be transferred to its subfolders

        checkAccessRight(f8, "u1");
        checkAccessRight(f8, "u2");
        checkAccessRight(f8, "root");

    }

    private static void checkAccessRight(FolderProp f, String u) {

        while(f != null){
            if(f.userAccess.contains(u)){
                System.out.println("User " + u + " has access");
                return;
            }
            f = f.parentFolder;
        }
        System.out.println("User " + u + " has no access");

    }

}
