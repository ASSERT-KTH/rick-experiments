#!/bin/bash
# define workload PDFs
workloads=(./workload/000752 ./workload/000753 ./workload/000809 ./workload/000810 ./workload/000817)
overlay_pdf="./workload/000142"
extension=".pdf"
pdfbox_jar_loc="./pdfbox-app-2.0.24.jar"

# execute PDFBox functionalities for each workload
for i in ${workloads[@]}
do
  # Encrypt
  echo "Encrypt " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} Encrypt -O 123 -U 123 ${i}${extension} ${i}-locked${extension} > traces/encrypt-trace.txt

  # Decrypt
  echo "Decrypt " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} Decrypt -password 123 ${i}-locked${extension} ${i}-unlocked${extension} > traces/dencrypt-trace.txt

  # ExtractText
  echo "ExtractText " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} ExtractText -password 123 -sort ${i}-locked${extension} ${i}-from-pdf.txt > traces/extract-text-trace.txt

  # ExtractImages
  echo "ExtractImages " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} ExtractImages -password 123 -directJPEG ${i}-locked${extension} > traces/extract-images-trace.txt

  # PDFToImage
  echo "PDFToImage " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} PDFToImage -password 123 -imageType png -outputPrefix workloadAsImage -time ${i}-locked${extension} > traces/pdf-to-image-trace.txt

  # TextToPDF
  echo "TextToPDF " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} TextToPDF -standardFont Helvetica-BoldOblique -fontSize 18 ${i}-from-txt${extension} ${i}-from-pdf.txt > traces/text-to-pdf-trace.txt

  # PDFSplit
  echo "PDFSplit " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc}  PDFSplit -password 123 -split 1 ${i}-locked${extension} > traces/pdf-split-trace.txt

  # PDFMerger
  echo "PDFMerger " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} PDFMerger ${i}-locked-*${extension} ${i}-merged${extension} > traces/pdf-merger-trace.txt

  # WriteDecodedDoc
  echo "WriteDecodedDoc " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} WriteDecodedDoc -password 123 ${i}-locked${extension} ${i}-decoded${extension} > traces/write-decode-doc-trace.txt

  # OverlayPDF
  echo "OverlayPDF " ${i}${extension}
  java -javaagent:javacg-0.1-SNAPSHOT-dycg-agent.jar="incl=org.apache.*" -cp javacg-0.1-SNAPSHOT-dycg-agent.jar -jar ${pdfbox_jar_loc} OverlayPDF ${i}${extension} ${overlay_pdf}${extension} -position foreground ${i}-overlaid${extension} > traces/overlap-pdf-trace.txt
done
