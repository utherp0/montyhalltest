package org.uth.montyhall;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/experiment1")
public class Experiment1
{
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String performExperiment( @DefaultValue("100") @QueryParam("runs") int runs )
  {
    StringBuilder response = new StringBuilder();

    Random random = new Random();

    // The running totals
    int failures = 0;
    int success_stick = 0;
    int success_twist = 0;

    // Repeat the experiment 'runs' times
    for( int loop = 0; loop < runs; loop++ )
    {
      // Pick the box with the prize
      int correctBox = random.nextInt(3);

      // Pick a box
      int playerChoice = random.nextInt(3);

      // Decide on the option to provide for backup choice
      int option = correctBox;

      if( correctBox == playerChoice )
      {
        while( option == correctBox )
        {
          option = random.nextInt(3);
        }
      }

      // Randomly decide to stick with the playerChoice or twist to the option
      boolean stick = random.nextBoolean();

      if( !stick ) playerChoice = option;

      // Have we won?
      if( playerChoice != correctBox )
      {
        failures++;
      }
      else
      {
        if( stick )
        {
          success_stick++;
        }
        else
        {
          success_twist++;
        }
      }
    }

    // Build a response package
    response.append( "Total runs: " + runs + " failures: " + failures + " success(stick): " + success_stick + " success(twist): " + success_twist );

    return response.toString();
  }
}
