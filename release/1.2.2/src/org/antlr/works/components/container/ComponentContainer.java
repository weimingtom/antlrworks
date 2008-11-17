package org.antlr.works.components.container;

import org.antlr.works.components.document.ComponentDocument;
import org.antlr.works.components.editor.ComponentEditor;
import org.antlr.works.components.editor.ComponentEditorGrammar;
import org.antlr.works.debugger.Debugger;
import org.antlr.works.editor.EditorTab;
import org.antlr.works.menu.ActionDebugger;
import org.antlr.works.menu.ActionGoTo;
import org.antlr.works.menu.ActionRefactor;
import org.antlr.works.menu.ContextualMenuFactory;
import org.antlr.xjlib.appkit.frame.XJFrameInterface;
import org.antlr.xjlib.appkit.menu.XJMainMenuBar;
import org.antlr.xjlib.appkit.menu.XJMenu;
import org.antlr.xjlib.appkit.menu.XJMenuItem;

import javax.swing.*;
import java.awt.*;
/*

[The "BSD licence"]
Copyright (c) 2005 Jean Bovet
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*/

public interface ComponentContainer {

    void awake();
    void assemble(boolean separateRules);
    void dirtyChanged();
    
    void createFile(String name);

    public void setEditor(ComponentEditor editor);
    public ComponentEditor getEditor();
    public void setDocument(ComponentDocument document);
    public ComponentDocument getDocument();

    public Dimension getSize();
    
    public XJFrameInterface getXJFrame();
    public XJMainMenuBar getMainMenuBar();

    public void becomingVisibleForTheFirstTime();

    public void setDirty();
    public boolean close();
    void saveAll();

    public ContextualMenuFactory createContextualMenuFactory();
    public JPopupMenu getContextualMenu(int textIndex);

    EditorTab getSelectedTab();
    void selectTab(Component c);
    void addTab(EditorTab tab);

    void documentLoaded(ComponentDocument document);

    void editorParsed(ComponentEditor editor);
    
    void selectConsoleTab(ComponentEditor editor);
    void selectInterpreterTab(ComponentEditor editor);
    void selectSyntaxDiagramTab(ComponentEditor editor);

    ComponentEditorGrammar selectGrammar(String name);
    ComponentEditorGrammar getSelectedEditor();

    void editorContentChanged();

    Debugger getDebugger();
    
    ActionDebugger getActionDebugger();
    ActionRefactor getActionRefactor();
    ActionGoTo getActionGoTo();

    void windowActivated();

    void customizeFileMenu(XJMenu menu);
    void customizeMenuBar(XJMainMenuBar menubar);

    void menuItemState(XJMenuItem item);
    void handleMenuSelected(XJMenu menu);

    JComponent getRulesComponent();
    JComponent getEditorComponent();
}