public class ReturnLongestCommonSubsequence
{
  public static void main(String[] args)
  {
    ReturnLongestCommonSubsequence r = new ReturnLongestCommonSubsequence();
    String s1 = "elephant";
    String s2 = "erepat";
    int index1 = 0;
    int index2 = 0;

    // System.out.println(r.longestCommonSubsequence(s1, s2, index1, index2));
    System.out.println(r.lcs(s1, s2, 0, 0));
  }

  // public char[] longestCommonSubsequence(String s1, String s2, int index1, int index2)
  // {
  //   int dp[][] = new int[index1 + 1][index2 + 1];
  //   for(int i=0; i<=index1; i++)
  //   {
  //     for(int j=0; j<=index2; j++)
  //     {
  //       if(i == 0 || j == 0)
  //       {
  //         dp[i][j] = 0;
  //       }
  //       else if(s1.charAt(i - 1) == s1.charAt(j - 1))
  //       {
  //         dp[i][j] = 1 + dp[i - 1][j - 1];
  //       }
  //       else 
  //       {
  //         dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
  //       }
  //     }
  //   }

  //   int index = dp[index1][index2];
  //   int temp = index;

  //   char lcs[] = new char[index + 1];
  //   lcs[index] = "\u0000";

  //   int i = index1;
  //   int j = index2;
  //   while (i > 0 && j > 0)
  //   {
  //     if(s1.charAt(i - 1) == s2.charAt(j - 1))
  //     {
  //       lcs[index - 1] = s1.charAt(i - 1);
  //       i--;
  //       j--;
  //       index--;
  //     }
  //     else if(dp[i - 1][j] > dp[i][j - 1])
  //     {
  //       i--;
  //     }
  //     else 
  //     {
  //       j--;
  //     }
  //   }
  //   return lcs;
  // }

  public char[] lcs(String X, String Y, int m, int n)
	{
		int[][] L = new int[m+1][n+1];
 
		// Following steps build L[m+1][n+1] in bottom up fashion. Note
		// that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		for (int i=0; i<=m; i++)
		{
			for (int j=0; j<=n; j++)
			{
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i-1) == Y.charAt(j-1))
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}
 
		// Following code is used to print LCS
		int index = L[m][n];
		int temp = index;
 
		// Create a character array to store the lcs string
		char[] lcs = new char[index+1];
		lcs[index] = '\u0000'; // Set the terminating character
 
		// Start from the right-most-bottom-most corner and
		// one by one store characters in lcs[]
		int i = m;
		int j = n;
		while (i > 0 && j > 0)
		{
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (X.charAt(i-1) == Y.charAt(j-1))
			{
				// Put current character in result
				lcs[index-1] = X.charAt(i-1);
				
				// reduce values of i, j and index
				i--;
				j--;
				index--;	
			}
 
			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (L[i-1][j] > L[i][j-1])
				i--;
			else
				j--;
		}
		
 
		// Print the lcs
	
		return lcs;
	
	}
}