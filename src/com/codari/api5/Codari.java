package com.codari.api5;

import org.bukkit.plugin.Plugin;

import com.codari.api5.metadata.MetadataManager;
import com.codari.api5.stats.StatFactory;
import com.codari.arena5.ArenaManager;

/**
 * Codari instance of {@link org.bukkit.plugin.Plugin}.
 * 
 * @author Soren025
 */
public interface Codari extends Plugin {
	//-----Instance Field-----//
	/**
	 * Instance of the Codari Plugin, this value is null if the plugin is not enabled.
	 */
	public final static Codari INSTANCE = null;
	
	//-----Methods-----//
	public MetadataManager getMetadataManager();
	/**
	 * Gets the Arena Manager of the plugin.
	 * 
	 * @return The Arena Manager.
	 */
	public ArenaManager getArenaManager();
	
	public StatFactory getStatFactory();
	/**
	 * Check out the info below.
	 * 
	 * <section class="main">
			<table summary="Ye who dare understand the
				meaning behind this table be warned, THERE IS NONE!">
				
				<caption>THIS IS A TABLE, WHO WOULDA GUESSED!</caption>
				
				<thead>
					<tr>
						<th>THIS</th>
						<th>IS</th>
						<th>THE</th>
						<th>TABLE</th>
						<th>HEAD</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>THIS</td>
						<td>IS</td>
						<td>TABLE</td>
						<td>DATA</td>
						<td>ROW 1!</td>
					</tr>
					
					<tr>
						<td>THIS</td>
						<td>IS</td>
						<td>TABLE</td>
						<td>DATA</td>
						<td>ROW 2!</td>
					</tr>
					
					<tr>
						<td rowspan="2">THIS</td>
						<td>IS</td>
						<td>TABLE</td>
						<td>DATA</td>
						<td>ROW 3!</td>
					</tr>
					
					<tr>
						<td>IS</td>
						<td>TABLE</td>
						<td>DATA</td>
						<td>ROW 4!</td>
					</tr>
					
					<tr>
						<td colspan="5">THIS IS TABLE DATA ROW 5!</td>
					</tr>
					
					<tr>
						<td rowspan="3" colspan="4">THIS IS TABLE DATA ROW</td>
						<td>6!</td>
					</tr>
					
					<tr>
						<td>7!</td>
					</tr>
					
					<tr>
						<td>AND 8!</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
						<td rowspan="250" colspan="4">BIG TABLE DATA CELL <a href="#half" title="RANDOM LINK">CLICK TO GO HALF WAY DOWN</a></td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr id="half">
						<td>REALLY (about half way there)</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
					
					<tr>
						<td>REALLY</td>
					</tr>
				</tbody>
			</table>
		</section>
	 */
	public void doNothingMethodOfNothing();
}