#!/bin/bash
# define workload PDFs
workloads=(./workload/000752 ./workload/000753 ./workload/000809 ./workload/000810 ./workload/000817)
overlay_pdf="./workload/000142"
extension=".pdf"
glowroot_jar_loc="/path/to/glowroot/glowroot.jar"
pdfbox_jar_loc="./app/target/pdfbox-app-2.0.24.jar"

# execute PDFBox functionalities for each workload
for i in ${workloads[@]}
do
  # Encrypt
  echo "Encrypt " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} Encrypt -O 123 -U 123 ${i}${extension} ${i}-locked${extension}

  # Decrypt
  echo "Decrypt " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} Decrypt -password 123 ${i}-locked${extension} ${i}-unlocked${extension}

  # ExtractText
  echo "ExtractText " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} ExtractText -password 123 -sort ${i}-locked${extension} ${i}-from-pdf.txt

  # ExtractImages
  echo "ExtractImages " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} ExtractImages -password 123 -directJPEG ${i}-locked${extension}

  # PDFToImage
  echo "PDFToImage " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} PDFToImage -password 123 -imageType png -outputPrefix workloadAsImage -time ${i}-locked${extension}

  # TextToPDF
  echo "TextToPDF " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} TextToPDF -standardFont Helvetica-BoldOblique -fontSize 18 ${i}-from-txt${extension} ${i}-from-pdf.txt

  # PDFSplit
  echo "PDFSplit " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc}  PDFSplit -password 123 -split 1 ${i}-locked${extension}

  # PDFMerger
  echo "PDFMerger " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} PDFMerger ${i}-locked-*${extension} ${i}-merged${extension}

  # WriteDecodedDoc
  echo "WriteDecodedDoc " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} WriteDecodedDoc -password 123 ${i}-locked${extension} ${i}-decoded${extension}

  # OverlayPDF
  echo "OverlayPDF " ${i}${extension}
  java -javaagent:${glowroot_jar_loc} -jar ${pdfbox_jar_loc} OverlayPDF ${i}${extension} ${overlay_pdf}${extension} -position foreground ${i}-overlaid${extension}
done
