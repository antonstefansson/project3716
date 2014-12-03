package as.Assignment;

import as.Score.Score;

public class Assignment
{
	private Score score;
	private String content;
	public Assignment(String content,final int score)
	{
		this.content=content;
		this.score=new Score(score);
	}
	public String getContent()
	{
		return content;
	}
	public void setScore(final int score)
	{
		this.score.setScore(score);
	}
}