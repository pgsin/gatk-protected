/*
*  By downloading the PROGRAM you agree to the following terms of use:
*  
*  BROAD INSTITUTE - SOFTWARE LICENSE AGREEMENT - FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
*  
*  This Agreement is made between the Broad Institute, Inc. with a principal address at 7 Cambridge Center, Cambridge, MA 02142 (BROAD) and the LICENSEE and is effective at the date the downloading is completed (EFFECTIVE DATE).
*  
*  WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
*  WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
*  NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
*  
*  1. DEFINITIONS
*  1.1 PROGRAM shall mean copyright in the object code and source code known as GATK2 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute/GATK on the EFFECTIVE DATE.
*  
*  2. LICENSE
*  2.1   Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. 
*  The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only.  For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
*  2.2  No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD.  LICENSEE shall ensure that all of its users agree to the terms of this Agreement.  LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
*  2.3  License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.  
*  
*  3. OWNERSHIP OF INTELLECTUAL PROPERTY 
*  LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies.  LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
*  Copyright 2012 Broad Institute, Inc.
*  Notice of attribution:  The GATK2 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
*  LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
*  
*  4. INDEMNIFICATION
*  LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
*  
*  5. NO REPRESENTATIONS OR WARRANTIES
*  THE PROGRAM IS DELIVERED AS IS.  BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
*  IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
*  
*  6. ASSIGNMENT
*  This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
*  
*  7. MISCELLANEOUS
*  7.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
*  7.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
*  7.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
*  7.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested.  All notices under this Agreement shall be deemed effective upon receipt. 
*  7.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter. 
*  7.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
*  7.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.sting.gatk.walkers.haplotypecaller;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import net.sf.samtools.Cigar;
import net.sf.samtools.CigarElement;
import net.sf.samtools.CigarOperator;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.broadinstitute.sting.gatk.walkers.haplotypecaller.graphs.*;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.haplotype.Haplotype;
import org.broadinstitute.sting.utils.activeregion.ActiveRegion;
import org.broadinstitute.sting.utils.sam.AlignmentUtils;
import org.broadinstitute.sting.utils.sam.GATKSAMRecord;
import org.broadinstitute.sting.utils.sam.ReadUtils;
import org.broadinstitute.sting.utils.smithwaterman.SWPairwiseAlignment;
import org.broadinstitute.sting.utils.smithwaterman.SWParameterSet;
import org.broadinstitute.variant.variantcontext.Allele;
import org.broadinstitute.variant.variantcontext.VariantContext;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

/**
 * Abstract base class for all HaplotypeCaller assemblers
 *
 * User: ebanks
 * Date: Mar 14, 2011
 */
public abstract class LocalAssemblyEngine {
    private final static Logger logger = Logger.getLogger(LocalAssemblyEngine.class);

    /**
     * If false, we will only write out a region around the reference source
     */
    private final static boolean PRINT_FULL_GRAPH_FOR_DEBUGGING = true;
    public static final byte DEFAULT_MIN_BASE_QUALITY_TO_USE = (byte) 8;
    private static final int MIN_HAPLOTYPE_REFERENCE_LENGTH = 30;

    protected final int numBestHaplotypesPerGraph;

    protected boolean debug = false;
    protected boolean allowCyclesInKmerGraphToGeneratePaths = false;
    protected boolean debugGraphTransformations = false;
    protected boolean recoverDanglingTails = true;

    protected byte minBaseQualityToUseInAssembly = DEFAULT_MIN_BASE_QUALITY_TO_USE;
    protected int pruneFactor = 2;
    protected boolean errorCorrectKmers = false;

    private PrintStream graphWriter = null;

    /**
     * Create a new LocalAssemblyEngine with all default parameters, ready for use
     * @param numBestHaplotypesPerGraph the number of haplotypes to generate for each assembled graph
     */
    protected LocalAssemblyEngine(final int numBestHaplotypesPerGraph) {
        if ( numBestHaplotypesPerGraph < 1 ) throw new IllegalArgumentException("numBestHaplotypesPerGraph should be >= 1 but got " + numBestHaplotypesPerGraph);
        this.numBestHaplotypesPerGraph = numBestHaplotypesPerGraph;
    }

    /**
     * Main subclass function: given reads and a reference haplotype give us graphs to use for constructing
     * non-reference haplotypes.
     *
     * @param reads the reads we're going to assemble
     * @param refHaplotype the reference haplotype
     * @return a non-null list of reads
     */
    protected abstract List<SeqGraph> assemble(List<GATKSAMRecord> reads, Haplotype refHaplotype, List<Haplotype> activeAlleleHaplotypes);

    protected List<SeqGraph> assemble(List<GATKSAMRecord> reads, Haplotype refHaplotype) {
        return assemble(reads, refHaplotype, Collections.<Haplotype>emptyList());
    }

    /**
     * Main entry point into the assembly engine. Build a set of deBruijn graphs out of the provided reference sequence and list of reads
     * @param activeRegion              ActiveRegion object holding the reads which are to be used during assembly
     * @param refHaplotype              reference haplotype object
     * @param fullReferenceWithPadding  byte array holding the reference sequence with padding
     * @param refLoc                    GenomeLoc object corresponding to the reference sequence with padding
     * @param activeAllelesToGenotype   the alleles to inject into the haplotypes during GGA mode
     * @return                          a non-empty list of all the haplotypes that are produced during assembly
     */
    public List<Haplotype> runLocalAssembly(ActiveRegion activeRegion, Haplotype refHaplotype, byte[] fullReferenceWithPadding, GenomeLoc refLoc, List<VariantContext> activeAllelesToGenotype) {
        if( activeRegion == null ) { throw new IllegalArgumentException("Assembly engine cannot be used with a null ActiveRegion."); }
        if( refHaplotype == null ) { throw new IllegalArgumentException("Reference haplotype cannot be null."); }
        if( fullReferenceWithPadding.length != refLoc.size() ) { throw new IllegalArgumentException("Reference bases and reference loc must be the same size."); }
        if( pruneFactor < 0 ) { throw new IllegalArgumentException("Pruning factor cannot be negative"); }

        // create the list of artificial haplotypes that should be added to the graph for GGA mode
        final List<Haplotype> activeAlleleHaplotypes = createActiveAlleleHaplotypes(refHaplotype, activeAllelesToGenotype, activeRegion.getExtendedLoc());

        // create the graphs by calling our subclass assemble method
        final List<SeqGraph> graphs = assemble(activeRegion.getReads(), refHaplotype, activeAlleleHaplotypes);

        // do some QC on the graphs
        for ( final SeqGraph graph : graphs ) { sanityCheckGraph(graph, refHaplotype); }

        // print the graphs if the appropriate debug option has been turned on
        if ( graphWriter != null ) { printGraphs(graphs); }

        // find the best paths in the graphs and return them as haplotypes
        return findBestPaths( graphs, refHaplotype, refLoc, activeRegion.getExtendedLoc() );
    }

    /**
     * Create the list of artificial GGA-mode haplotypes by injecting each of the provided alternate alleles into the reference haplotype
     * @param refHaplotype the reference haplotype
     * @param activeAllelesToGenotype the list of alternate alleles in VariantContexts
     * @param activeRegionWindow the window containing the reference haplotype
     * @return a non-null list of haplotypes
     */
    private List<Haplotype> createActiveAlleleHaplotypes(final Haplotype refHaplotype, final List<VariantContext> activeAllelesToGenotype, final GenomeLoc activeRegionWindow) {
        final Set<Haplotype> returnHaplotypes = new LinkedHashSet<>();
        final int activeRegionStart = refHaplotype.getAlignmentStartHapwrtRef();

        for( final VariantContext compVC : activeAllelesToGenotype ) {
            for( final Allele compAltAllele : compVC.getAlternateAlleles() ) {
                final Haplotype insertedRefHaplotype = refHaplotype.insertAllele(compVC.getReference(), compAltAllele, activeRegionStart + compVC.getStart() - activeRegionWindow.getStart(), compVC.getStart());
                if( insertedRefHaplotype != null ) { // can be null if the requested allele can't be inserted into the haplotype
                    returnHaplotypes.add(insertedRefHaplotype);
                }
            }
        }

        return new ArrayList<>(returnHaplotypes);
    }

    @Ensures({"result.contains(refHaplotype)"})
    protected List<Haplotype> findBestPaths(final List<SeqGraph> graphs, final Haplotype refHaplotype, final GenomeLoc refLoc, final GenomeLoc activeRegionWindow) {
        // add the reference haplotype separately from all the others to ensure that it is present in the list of haplotypes
        final Set<Haplotype> returnHaplotypes = new LinkedHashSet<>();
        returnHaplotypes.add( refHaplotype );

        final int activeRegionStart = refHaplotype.getAlignmentStartHapwrtRef();

        for( final SeqGraph graph : graphs ) {
            final SeqVertex source = graph.getReferenceSourceVertex();
            final SeqVertex sink = graph.getReferenceSinkVertex();
            if ( source == null || sink == null ) throw new IllegalArgumentException("Both source and sink cannot be null but got " + source + " and sink " + sink + " for graph "+ graph);

            final KBestPaths<SeqVertex,BaseEdge> pathFinder = new KBestPaths<>(allowCyclesInKmerGraphToGeneratePaths);
            for ( final Path<SeqVertex,BaseEdge> path : pathFinder.getKBestPaths(graph, numBestHaplotypesPerGraph, source, sink) ) {
                Haplotype h = new Haplotype( path.getBases() );
                if( !returnHaplotypes.contains(h) ) {
                    final Cigar cigar = path.calculateCigar(refHaplotype.getBases());

                    if ( cigar == null ) {
                        // couldn't produce a meaningful alignment of haplotype to reference, fail quietly
                        continue;
                    } else if( cigar.isEmpty() ) {
                        throw new IllegalStateException("Smith-Waterman alignment failure. Cigar = " + cigar + " with reference length " + cigar.getReferenceLength() +
                                " but expecting reference length of " + refHaplotype.getCigar().getReferenceLength());
                    } else if ( pathIsTooDivergentFromReference(cigar) || cigar.getReferenceLength() < MIN_HAPLOTYPE_REFERENCE_LENGTH ) {
                        // N cigar elements means that a bubble was too divergent from the reference so skip over this path
                        continue;
                    } else if( cigar.getReferenceLength() != refHaplotype.getCigar().getReferenceLength() ) { // SW failure
                        throw new IllegalStateException("Smith-Waterman alignment failure. Cigar = " + cigar + " with reference length "
                                + cigar.getReferenceLength() + " but expecting reference length of " + refHaplotype.getCigar().getReferenceLength()
                                + " ref = " + refHaplotype + " path " + new String(path.getBases()));
                    }

                    h.setCigar(cigar);
                    h.setAlignmentStartHapwrtRef(activeRegionStart);
                    h.setScore(path.getScore());
                    returnHaplotypes.add(h);

                    if ( debug )
                        logger.info("Adding haplotype " + h.getCigar() + " from graph with kmer " + graph.getKmerSize());
                }
            }
        }

        // add genome locs to the haplotypes
        for ( final Haplotype h : returnHaplotypes ) h.setGenomeLocation(activeRegionWindow);

        if ( returnHaplotypes.size() < returnHaplotypes.size() )
            logger.info("Found " + returnHaplotypes.size() + " candidate haplotypes of " + returnHaplotypes.size() + " possible combinations to evaluate every read against at " + refLoc);

        if( debug ) {
            if( returnHaplotypes.size() > 1 ) {
                logger.info("Found " + returnHaplotypes.size() + " candidate haplotypes of " + returnHaplotypes.size() + " possible combinations to evaluate every read against.");
            } else {
                logger.info("Found only the reference haplotype in the assembly graph.");
            }
            for( final Haplotype h : returnHaplotypes ) {
                logger.info( h.toString() );
                logger.info( "> Cigar = " + h.getCigar() + " : " + h.getCigar().getReferenceLength() + " score " + h.getScore() + " ref " + h.isReference());
            }
        }

        return new ArrayList<>(returnHaplotypes);
    }

    /**
     * We use CigarOperator.N as the signal that an incomplete or too divergent bubble was found during bubble traversal
     * @param c the cigar to test
     * @return  true if we should skip over this path
     */
    @Requires("c != null")
    private boolean pathIsTooDivergentFromReference( final Cigar c ) {
        for( final CigarElement ce : c.getCigarElements() ) {
            if( ce.getOperator().equals(CigarOperator.N) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print graph to file if debugGraphTransformations is enabled
     * @param graph the graph to print
     * @param file the destination file
     */
    protected void printDebugGraphTransform(final BaseGraph graph, final File file) {
        if ( debugGraphTransformations ) {
            if ( PRINT_FULL_GRAPH_FOR_DEBUGGING )
                graph.printGraph(file, pruneFactor);
            else
                graph.subsetToRefSource().printGraph(file, pruneFactor);
        }
    }

    protected SeqGraph cleanupSeqGraph(final SeqGraph seqGraph) {
        printDebugGraphTransform(seqGraph, new File("sequenceGraph.1.dot"));

        // the very first thing we need to do is zip up the graph, or pruneGraph will be too aggressive
        seqGraph.zipLinearChains();
        printDebugGraphTransform(seqGraph, new File("sequenceGraph.2.zipped.dot"));

        // now go through and prune the graph, removing vertices no longer connected to the reference chain
        // IMPORTANT: pruning must occur before we call simplifyGraph, as simplifyGraph adds 0 weight
        // edges to maintain graph connectivity.
        seqGraph.pruneGraph(pruneFactor);
        seqGraph.removeVerticesNotConnectedToRefRegardlessOfEdgeDirection();

        printDebugGraphTransform(seqGraph, new File("sequenceGraph.3.pruned.dot"));
        seqGraph.simplifyGraph();
        printDebugGraphTransform(seqGraph, new File("sequenceGraph.4.merged.dot"));

        // The graph has degenerated in some way, so the reference source and/or sink cannot be id'd.  Can
        // happen in cases where for example the reference somehow manages to acquire a cycle, or
        // where the entire assembly collapses back into the reference sequence.
        if ( seqGraph.getReferenceSourceVertex() == null || seqGraph.getReferenceSinkVertex() == null )
            return null;

        seqGraph.removePathsNotConnectedToRef();
        seqGraph.simplifyGraph();
        if ( seqGraph.vertexSet().size() == 1 ) {
            // we've perfectly assembled into a single reference haplotype, add a empty seq vertex to stop
            // the code from blowing up.
            // TODO -- ref properties should really be on the vertices, not the graph itself
            final SeqVertex complete = seqGraph.vertexSet().iterator().next();
            final SeqVertex dummy = new SeqVertex("");
            seqGraph.addVertex(dummy);
            seqGraph.addEdge(complete, dummy, new BaseEdge(true, 0));
        }
        printDebugGraphTransform(seqGraph, new File("sequenceGraph.5.final.dot"));

        return seqGraph;
    }

    /**
     * Perform general QC on the graph to make sure something hasn't gone wrong during assembly
     * @param graph the graph to check
     * @param refHaplotype the reference haplotype
     */
    private <T extends BaseVertex, E extends BaseEdge> void sanityCheckGraph(final BaseGraph<T,E> graph, final Haplotype refHaplotype) {
        sanityCheckReferenceGraph(graph, refHaplotype);
    }

    /**
     * Make sure the reference sequence is properly represented in the provided graph
     *
     * @param graph the graph to check
     * @param refHaplotype the reference haplotype
     */
    private <T extends BaseVertex, E extends BaseEdge> void sanityCheckReferenceGraph(final BaseGraph<T,E> graph, final Haplotype refHaplotype) {
        if( graph.getReferenceSourceVertex() == null ) {
            throw new IllegalStateException("All reference graphs must have a reference source vertex.");
        }
        if( graph.getReferenceSinkVertex() == null ) {
            throw new IllegalStateException("All reference graphs must have a reference sink vertex.");
        }
        if( !Arrays.equals(graph.getReferenceBytes(graph.getReferenceSourceVertex(), graph.getReferenceSinkVertex(), true, true), refHaplotype.getBases()) ) {
            throw new IllegalStateException("Mismatch between the reference haplotype and the reference assembly graph path. for graph " + graph +
                    " graph = " + new String(graph.getReferenceBytes(graph.getReferenceSourceVertex(), graph.getReferenceSinkVertex(), true, true)) +
                    " haplotype = " + new String(refHaplotype.getBases())
            );
        }
    }

    /**
     * Print the generated graphs to the graphWriter
     * @param graphs a non-null list of graphs to print out
     */
    private void printGraphs(final List<SeqGraph> graphs) {
        final int writeFirstGraphWithSizeSmallerThan = 50;

        graphWriter.println("digraph assemblyGraphs {");
        for( final SeqGraph graph : graphs ) {
            if ( debugGraphTransformations && graph.getKmerSize() >= writeFirstGraphWithSizeSmallerThan ) {
                logger.info("Skipping writing of graph with kmersize " + graph.getKmerSize());
                continue;
            }

            graph.printGraph(graphWriter, false, pruneFactor);

            if ( debugGraphTransformations )
                break;
        }

        graphWriter.println("}");
    }

    // -----------------------------------------------------------------------------------------------
    //
    // getter / setter routines for generic assembler properties
    //
    // -----------------------------------------------------------------------------------------------

    public int getPruneFactor() {
        return pruneFactor;
    }

    public void setPruneFactor(int pruneFactor) {
        this.pruneFactor = pruneFactor;
    }

    public boolean shouldErrorCorrectKmers() {
        return errorCorrectKmers;
    }

    public void setErrorCorrectKmers(boolean errorCorrectKmers) {
        this.errorCorrectKmers = errorCorrectKmers;
    }

    public void setGraphWriter(PrintStream graphWriter) {
        this.graphWriter = graphWriter;
    }

    public byte getMinBaseQualityToUseInAssembly() {
        return minBaseQualityToUseInAssembly;
    }

    public void setMinBaseQualityToUseInAssembly(byte minBaseQualityToUseInAssembly) {
        this.minBaseQualityToUseInAssembly = minBaseQualityToUseInAssembly;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isAllowCyclesInKmerGraphToGeneratePaths() {
        return allowCyclesInKmerGraphToGeneratePaths;
    }

    public void setAllowCyclesInKmerGraphToGeneratePaths(boolean allowCyclesInKmerGraphToGeneratePaths) {
        this.allowCyclesInKmerGraphToGeneratePaths = allowCyclesInKmerGraphToGeneratePaths;
    }

    public boolean isDebugGraphTransformations() {
        return debugGraphTransformations;
    }

    public void setDebugGraphTransformations(boolean debugGraphTransformations) {
        this.debugGraphTransformations = debugGraphTransformations;
    }

    public boolean isRecoverDanglingTails() {
        return recoverDanglingTails;
    }

    public void setRecoverDanglingTails(boolean recoverDanglingTails) {
        this.recoverDanglingTails = recoverDanglingTails;
    }
}
