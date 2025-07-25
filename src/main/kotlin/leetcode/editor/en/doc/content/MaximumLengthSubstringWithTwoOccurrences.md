Given a string <code>s</code>, return the <strong>maximum</strong> length of a <span data-keyword="substring">substring</span>&nbsp;such that it contains <em>at most two occurrences</em> of each character.

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "bcbbbcba"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p> The following substring has a length of 4 and contains at most two occurrences of each character: 
<code>"bcbb<u>bcba</u>"</code>.

<p><strong class="example">Example 2:</strong></p>

<div class="example-block"> 
 <p><strong>Input:</strong> <span class="example-io">s = "aaaa"</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p> The following substring has a length of 2 and contains at most two occurrences of each character: 
<code>"<u>aa</u>aa"</code>.

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>2 &lt;= s.length &lt;= 100</code></li> 
 <li><code>s</code> consists only of lowercase English letters.</li> 
</ul>

<div><div>Related Topics</div><div><li>Hash Table</li><li>String</li><li>Sliding Window</li></div></div><br><div><li>👍 221</li><li>👎 19</li></div>