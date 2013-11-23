package test.datastructures.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructures.tree.HuffmanTree;

public class HuffmanTreeTest {

	@Test
	public void testGetCompressedString() {
		String text = "You tá the brinqueichon uite me, cara? You ar a véri mutchi caspa man. Do you nou the number one xampu contra caspa in the uordi. Luqui aqui Capitachion. Rimouve uarandredi porcenti ofi the caspa ande idrateiti ior hair.";
		HuffmanTree huffmanTree = new HuffmanTree(text);
		
		assertEquals("Huffman compression", 115, huffmanTree.getCompressedText().length);
	}

}
