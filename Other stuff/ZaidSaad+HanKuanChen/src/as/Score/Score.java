package as.Score;

public class Score
{
	private int get;
	private int full;
	public Score(final int full) 
	{
		this.get=0;
		this.full=full;
	}
	public void setScore(final int score)
	{
		get=score;
	}
	public int getScore()
	{
		return get;
	}
	public int getFullScore()
	{
		return full;
	}
}