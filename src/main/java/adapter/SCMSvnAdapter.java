package adapter;

import interfaces.ISCMAdapter;

public class SCMSvnAdapter implements ISCMAdapter {

    @Override
    public void add() { System.out.println("svn add"); }

    @Override
    public void commit() { System.out.println("svn commit"); }

    @Override
    public void push() { System.out.println("svn push"); }

    @Override
    public void pull() { System.out.println("svn pull"); }

    @Override
    public void checkout() { System.out.println("svn checkout"); }

    @Override
    public void branch() { System.out.println("svn branch"); }

}
