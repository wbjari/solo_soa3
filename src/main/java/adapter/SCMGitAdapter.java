package adapter;

import interfaces.ISCMAdapter;

public class SCMGitAdapter implements ISCMAdapter {

    @Override
    public void add() { System.out.println("git add"); }

    @Override
    public void commit() { System.out.println("git commit"); }

    @Override
    public void push() { System.out.println("git push"); }

    @Override
    public void pull() { System.out.println("git pull"); }

    @Override
    public void checkout() { System.out.println("git checkout"); }

    @Override
    public void branch() { System.out.println("git branch"); }

}
