/* *************************************************************************
 *
 *  TMPotter - Bi-text Aligner/TMX Editor
 *
 *  Copyright (C) 2016 Hiroshi Miura
 *
 *  This file is part of TMPotter.
 *
 *  TMPotter is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  TMPotter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with TMPotter.  If not, see http://www.gnu.org/licenses/.
 *
 * *************************************************************************/

package org.tmpotter.filters.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.tmpotter.ui.wizard.IImportWizardPanel;
import org.tmpotter.ui.wizard.ImportPreference;
import org.tmpotter.ui.wizard.ImportWizardController;
import org.tmpotter.util.MediaWikiDownloader;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.swing.JPanel;


/**
 * Wikimedia download progress pane.
 *
 * @author Hiroshi Miura
 */
public class ImportWizardWikimediaDownload extends javax.swing.JPanel implements IImportWizardPanel {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportWizardWikimediaDownload.class
            .getName());
    private ImportWizardController wizardController;
    private ImportPreference pref;
    private URI sourceUri;
    private URI translationUri;
    private File originalFilePath;
    private File translationFilePath;

    public static final String id = "WikimediaDownload";

    /**
     * Creates new form ImportWizardWikimediaDownload
     */
    public ImportWizardWikimediaDownload() {
    }

    public void init(final ImportWizardController controller, ImportPreference pref) {
        wizardController = controller;
        this.pref = pref;
        initComponents();
    }

    public void onShow() {
        wizardController.setButtonNextEnabled(false);
        downloadButton.setEnabled(true);
        sourceUri = pref.getOriginalFileUri();
        sourceUrlLabel.setText(sourceUri.toString());
        translationUri = pref.getTranslationFileUri();
        translationUrlLabel.setText(translationUri.toString());
    }

    public String getId() {
        return id;
    }

    public boolean isCombinedFormat() {
        return false;
    }

    public JPanel getPanel() {
        return this;
    }

    public String getName() {
        return "Wikimedia download";
    }

    public String getDesc() {
        return "Wikimeida download.";
    }

    public String getBackCommand() {
        return ImportWizardWikimedia.id;
    }

    public String getNextFinishCommand() {
        return "finish";
    }

    public void updatePref() {
        pref.setFilter("BiTextFilter");
        pref.setOriginalFilePath(originalFilePath);
        pref.setTranslationFilePath(translationFilePath);
    }

    /**
     * Does wikiread.
     */
    public void doWikiDownload() {
        File tempDirectory;
        wizardController.setButtonBackEnabled(false);
        downloadButton.setEnabled(false);
        translationProgressBar.setMinimum(0);
        translationProgressBar.setMaximum(100);
        try {
            tempDirectory = createTempDirectory();
            tempDirectory.deleteOnExit();
            translationProgressBar.setValue(30);
            File sourceFile = MediaWikiDownloader.download(sourceUri, tempDirectory);
            translationProgressBar.setValue(50);
            if (sourceFile != null) {
                originalFilePath = sourceFile;
            }
            File translationFile = MediaWikiDownloader.download(translationUri, tempDirectory);
            translationProgressBar.setValue(90);
            if (translationFile != null) {
                translationFilePath = translationFile;
            }
        } catch (Exception ex) {
            LOGGER.info("Mediawiki downloader:", ex);
            wizardController.setButtonNextEnabled(false);
            wizardController.setButtonBackEnabled(true);
            return;
        }
        wizardController.setButtonBackEnabled(true);
        wizardController.setButtonNextEnabled(true);
        translationProgressBar.setValue(100);
    }

    private static File createTempDirectory() throws IOException {
        final File temp;
        temp = File.createTempFile("temp", Long.toString(System.nanoTime()));
        if (!(temp.delete())) {
            throw new IOException("Could not delete temp file: " + temp.getAbsolutePath());
        }
        if (!(temp.mkdir())) {
            throw new IOException("Could not create temp directory: " + temp.getAbsolutePath());
        }
        return (temp);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                translationProgressBar = new javax.swing.JProgressBar();
                jLabel1 = new javax.swing.JLabel();
                sourceUrlLabel = new javax.swing.JLabel();
                translationUrlLabel = new javax.swing.JLabel();
                downloadButton = new javax.swing.JButton();

                jLabel1.setText("Source and Translation download");

                sourceUrlLabel.setText("Source URL");

                translationUrlLabel.setText("Translation URL");

                downloadButton.setText("Start Download");
                downloadButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                downloadButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(translationUrlLabel)
                                                        .addComponent(sourceUrlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(translationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(114, 114, 114)
                                                .addComponent(downloadButton)))
                                .addContainerGap(75, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(sourceUrlLabel)
                                .addGap(18, 18, 18)
                                .addComponent(translationUrlLabel)
                                .addGap(43, 43, 43)
                                .addComponent(translationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(downloadButton)
                                .addContainerGap(61, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
            doWikiDownload();
        }//GEN-LAST:event_downloadButtonActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton downloadButton;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel sourceUrlLabel;
        private javax.swing.JProgressBar translationProgressBar;
        private javax.swing.JLabel translationUrlLabel;
        // End of variables declaration//GEN-END:variables
}