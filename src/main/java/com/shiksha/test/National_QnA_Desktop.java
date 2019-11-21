package com.shiksha.test;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.Sanity_QA_Desktop;
import com.shiksha.resourses.CommonFunctions;

public class National_QnA_Desktop {
	CommonFunctions CommonFunctions = new CommonFunctions();
	Sanity_QA_Desktop sanity = null;

	public void AnA_HomePage(Objects obj) throws Exception {

		CommonFunctions CommonFunctions = new CommonFunctions(obj);
		String questionUrl = "";
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String FinalUrl = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunctions.createChild(report,
				"Registeration Widget",
				"Test Case login Action on Registeration Widget Started");
		ExtentTest child2 = CommonFunctions.createChild(report,
				"Question Posting", "Test Case Question Posting Started");
		ExtentTest child3 = CommonFunctions.createChild(report, "Edit Tags",
				"Test Case Edit Tags Started");
		ExtentTest child5 = CommonFunctions.createChild(report,
				"Question Actions : Follow/Unfollow",
				"Test Case Question Actions : Follow/Unfollow Started");
		ExtentTest child15 = CommonFunctions.createChild(report,
				"Question Actions : upvote",
				"Test Case Question Actions : upvote Started");
		ExtentTest child16 = CommonFunctions.createChild(report,
				"Question Actions : downvote",
				"Test Case Question Actions : downvote Started");
		ExtentTest child17 = CommonFunctions.createChild(report,
				"Question Actions : followers on layer",
				"Test Case Question Actions : followers on layer Started");
		ExtentTest child6 = CommonFunctions
				.createChild(report, "Disussion Comment",
						"Test Case To Post Comment on discussion, click view more Started");
		ExtentTest child7 = CommonFunctions.createChild(report,
				"Question Answer", "Test Case to ansewer a question Started");
		ExtentTest child8 = CommonFunctions.createChild(report, "Signout User",
				"Test Case to Signout current user Started");
		ExtentTest child4 = CommonFunctions.createChild(report,
				"Edit Question", "Test Case Edit Question Started");

		ExtentTest delcomm = CommonFunctions.createChild(report,
				"Delete Comment", "Test Case Delete Comment Started");
		ExtentTest delans = CommonFunctions.createChild(report,
				"Delete Answer", "Test Case Delete Answer Started");
		ExtentTest delques = CommonFunctions.createChild(report,
				"Delete Question", "Test Case delete Question Started");

		ExtentTest newchild1 = CommonFunctions.createChild(report,
				" Redirection on Right Side links",
				"Test Case Redirection on Right Side links Started");
		ExtentTest newchild2 = CommonFunctions.createChild(report,
				" Redirection on Expert pannel",
				"Test Case Redirection on Expert pannel Started");
		ExtentTest newchild3 = CommonFunctions.createChild(report,
				"Latest article widget",
				"Test Case Latest article widget Started");
		ExtentTest newchild4 = CommonFunctions.createChild(report,
				"college exp widget", "Test Case college exp Started");

		if (FinalUrl.contains("www")) {
			String str = FinalUrl;
			str = str.replace("www", "ask");
			FinalUrl = str;
		} else {
			String str = FinalUrl;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			FinalUrl = "https://ask." + uuu;
			System.out.print(FinalUrl);
		}

		try {
			sanity = new Sanity_QA_Desktop(obj, driver, child1);
			CommonFunctions.info(child1, "Registration Test Case "
					+ " for url : " + FinalUrl);
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			sanity.clickReigstrationWidget();

			// // Registration flow
			sanity.Registration(obj);

			sanity = new Sanity_QA_Desktop(obj, driver, child2);
			try {
				CommonFunctions.info(child2, "Question Posting Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.ClickQnATextBox("Scope of BBA in India over Nursing");
				sanity.ClickQnADescription();
				sanity.ClickQnADescriptionDetails("Scope of BBA in India over Nursing or Travel");
				sanity.clickNextButton();
				Thread.sleep(2000);
				sanity.clickaddMoreTags();
				Thread.sleep(2000);
				sanity.clickTagSearch("MBA");
				sanity.clicktag();
				Thread.sleep(2000);
				sanity.clicktagdone();
				sanity.clickPostQnA();
				sanity.verifyTags("MBA");
				questionUrl = driver.getCurrentUrl();
				sanity.verifyquestionTitle("Scope of BBA in India over Nursing");
				sanity.verifyDescription("Scope of BBA in India over Nursing or Travel");
				sanity = new Sanity_QA_Desktop(obj, driver, child3);
				CommonFunctions.info(child3, "Edit Tags Test Case "
						+ " for url : " + FinalUrl);
				sanity.clickEditoverFlowLayer();
				Thread.sleep(2000);
				sanity.clickEditTags();
				Thread.sleep(2000);
				sanity.clickaddMoreTags();
				Thread.sleep(2000);
				sanity.clickTagSearch("B.Tech");
				sanity.clicktag();
				sanity.clicktagdone();
				sanity.clickPostQnA();
				sanity.verifyTags("B.Tech");

				try {
					sanity = new Sanity_QA_Desktop(obj, driver, child4);
					CommonFunctions.info(child4, "Question Edit Test Case "
							+ " for url : " + FinalUrl);
					sanity.clickEditoverFlowLayer();
					Thread.sleep(2000);
					sanity.clickQuestion();
					Thread.sleep(2000);
					sanity.ClickQnATextBox(" or Engineering");
					sanity.ClickQnADescriptionDetails(" or any other Field over BBA");
					sanity.clickNextButton();
					sanity.clickaddMoreTags();
					sanity.clickTagSearch("Design");
					sanity.clicktag();
					sanity.clicktagdone();
					sanity.clickPostQnA();
					sanity.verifyquestionTitle("Scope of BBA in India over Nursing or Engineering");
					sanity.verifyDescription("Scope of BBA in India over Nursing or Travel or any other Field over BBA");
					sanity.verifyTags("Design");

					// // Delete Question
				} catch (Exception e) {
				}

				sanity = new Sanity_QA_Desktop(obj, driver, child5);
				CommonFunctions.info(child5,
						"Follow/Upvote/Downvote/Followers Test Case "
								+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				Thread.sleep(2000);
				sanity.verifyFollow();

				sanity = new Sanity_QA_Desktop(obj, driver, child15);
				CommonFunctions.info(child15,
						"Follow/Upvote/Downvote/Followers Test Case "
								+ " for url : " + FinalUrl);
				Thread.sleep(2000);
				sanity.verifyupvote();

				sanity = new Sanity_QA_Desktop(obj, driver, child16);
				CommonFunctions.info(child16,
						"Follow/Upvote/Downvote/Followers Test Case "
								+ " for url : " + FinalUrl);
				Thread.sleep(2000);
				sanity.verifydownvote();

				sanity = new Sanity_QA_Desktop(obj, driver, child17);
				CommonFunctions.info(child17,
						"Follow/Upvote/Downvote/Followers Test Case "
								+ " for url : " + FinalUrl);
				Thread.sleep(2000);
				sanity.clickFolowers();
				sanity.verifyFolowers();
				sanity.clickFollowonLayer();
				String answer = "Is there any scope of design in India";
				String comment = "Is there any scope of design in India";
				String commenturl = "";
				try {
					sanity = new Sanity_QA_Desktop(obj, driver, child6);
					CommonFunctions.info(child6, "Comment Posting Test Case "
							+ " for url : " + FinalUrl);
					driver.get(FinalUrl);
					CommonFunctions.acceptCookie(driver);
					sanity.clickDiscussionTab();
					sanity.verifyViewMoreonDiscussion();
					sanity.clickCommentAnswerButton();
					sanity.typeDiscussionComment(comment);
					sanity.clickPostAnswerComment();
					commenturl = driver.getCurrentUrl();
					driver.navigate().refresh();
					sanity.verifyCommentAnswerText(comment);
				} catch (Exception r) {

				} finally {
					if (commenturl.length() > 1) {
						sanity = new Sanity_QA_Desktop(obj, driver, delcomm);
						CommonFunctions.info(delcomm, "Delete comment :"
								+ " for url : " + FinalUrl);
						// // Delete comment
						driver.get(commenturl);
						CommonFunctions.acceptCookie(driver);
						sanity.clickEditoverFlowLayer2();
						sanity.deletecommentanswer();
						sanity.performAction();
						Thread.sleep(20000);
						driver.navigate().refresh();
						sanity.verifyCommentAnswerTexwt(comment);
					}
				}
				sanity = new Sanity_QA_Desktop(obj, driver, child7);
				CommonFunctions.info(child7, "Answer Posting Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				String ansurkl = "";
				try {
					sanity.clickAnswerTab();
					sanity.clickCommentAnswerButton();
					sanity.typeQuestionAnswer(answer);
					sanity.clickPostAnswerComment();
					ansurkl = driver.getCurrentUrl();
					driver.navigate().refresh();
					sanity.verifyCommentAnswerText(answer);
				} catch (Exception d) {

				} finally {
					if (ansurkl.length() > 1) {
						// // Delete answer
						sanity = new Sanity_QA_Desktop(obj, driver, delans);
						CommonFunctions.info(delans, "Delete anseer :"
								+ " for url : " + FinalUrl);
						driver.get(ansurkl);
						CommonFunctions.acceptCookie(driver);
						sanity.clickEditoverFlowLayer2();
						sanity.deletecommentanswer();
						sanity.performAction();
						Thread.sleep(20000);
						driver.navigate().refresh();
						sanity.verifyCommentAnswerTexwt(answer);
					}
				}

				sanity = new Sanity_QA_Desktop(obj, driver, newchild1);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.rightSideLinks();

				sanity = new Sanity_QA_Desktop(obj, driver, newchild2);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.expertPannel();

				sanity = new Sanity_QA_Desktop(obj, driver, newchild3);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.latestArticle();

				sanity = new Sanity_QA_Desktop(obj, driver, newchild4);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.collegexp();

				/*
				 * // // SignOut sanity = new Sanity_QA_Desktop(obj, driver,
				 * child8); CommonFunctions.info(child8, "Signout Test Case " +
				 * " for url : " + FinalUrl); driver.get(FinalUrl);
				 * sanity.signout();
				 */
			}

			catch (Exception e) {

			}

			finally {
				// // delete question
				if (questionUrl.length() > 1) {
					sanity = new Sanity_QA_Desktop(obj, driver, delques);
					CommonFunctions.info(delques, "Delete question :"
							+ " for url : " + FinalUrl);
					driver.get(questionUrl);
					CommonFunctions.acceptCookie(driver);
					sanity.clickEditoverFlowLayer();
					sanity.deletequestion();
					sanity.performAction();
					Thread.sleep(20000);
					sanity.verify(FinalUrl);

					// // SignOut sanity = new Sanity_QA_Desktop(obj, driver,
					// child8);
					CommonFunctions.info(child8, "Signout Test Case "
							+ " for url : " + FinalUrl);
					driver.get(FinalUrl);
					CommonFunctions.acceptCookie(driver);
					sanity.signout();

				}
			}
		}

		catch (Exception e) {

		} finally {
			CommonFunctions.closeChild(parent, child1, report);
			CommonFunctions.closeChild(parent, child2, report);
			CommonFunctions.closeChild(parent, child3, report);
			CommonFunctions.closeChild(parent, child4, report);
			CommonFunctions.closeChild(parent, child5, report);
			CommonFunctions.closeChild(parent, child15, report);
			CommonFunctions.closeChild(parent, child16, report);
			CommonFunctions.closeChild(parent, child17, report);
			CommonFunctions.closeChild(parent, child6, report);
			CommonFunctions.closeChild(parent, child7, report);
			CommonFunctions.closeChild(parent, delans, report);
			CommonFunctions.closeChild(parent, delcomm, report);
			CommonFunctions.closeChild(parent, delques, report);
			CommonFunctions.closeChild(parent, newchild1, report);
			CommonFunctions.closeChild(parent, newchild2, report);
			CommonFunctions.closeChild(parent, newchild3, report);
			CommonFunctions.closeChild(parent, newchild4, report);
			CommonFunctions.closeChild(parent, child8, report);
		}

	}

	public void AnA_Tag_Detail_Page(Objects obj) throws Exception {
		CommonFunctions CommonFunctions = new CommonFunctions(obj);
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String FinalUrl = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunctions.createChild(report,
				"Registeration Widget",
				"Test Case Registration for TDP Widget Started");
		ExtentTest child2 = CommonFunctions
				.createChild(report, "Follow",
						"Test Case Follow in any Discussion/Question/Tag for TDP Widget Started");
		ExtentTest child3 = CommonFunctions
				.createChild(report, "UpVote",
						"Test Case UpVote in any Discussion/Question/Tag for TDP Widget Started");
		ExtentTest child4 = CommonFunctions
				.createChild(report, "DownVote",
						"Test Case DownVote in any Discussion/Question/Tag for TDP Widget Started");
		ExtentTest child5 = CommonFunctions
				.createChild(report, "Follower",
						"Test Case Follower in any Discussion/Question/Tag for TDP Widget Started");
		ExtentTest child6 = CommonFunctions
				.createChild(
						report,
						"Discussion Comment",
						"Test Case Discussion Comment in any Discussion/Question/Tag for TDP Widget Started");
		ExtentTest child61 = CommonFunctions
				.createChild(
						report,
						"Discussion Comment Delete",
						"Test Case delete Discussion Comment in any Discussion/Question/Tag for TDP Widget Started");

		ExtentTest child7 = CommonFunctions
				.createChild(
						report,
						"Answer Comment",
						"Test Case Answer Comment in any Discussion/Question/Tag for TDP Widget Started");
		ExtentTest child71 = CommonFunctions
				.createChild(
						report,
						"Answer Comment delete",
						"Test Case delete Answer Comment in any Discussion/Question/Tag for TDP Widget Started");
		ExtentTest child8 = CommonFunctions.createChild(report, "Pagination",
				"Test Case Pagination for TDP Widget Started");

		ExtentTest child9 = CommonFunctions.createChild(report, "Related Tags",
				"Test Case Related Tags for TDP Widget Started");

		ExtentTest child10 = CommonFunctions.createChild(report, "Contributor",
				"Test Case Contributor for TDP Widget Started");

		FinalUrl = FinalUrl + "tags/cat-tdp-387254";

		try {
			sanity = new Sanity_QA_Desktop(obj, driver, child1);
			CommonFunctions.info(child1, "Registration Test Case "
					+ " for url : " + FinalUrl);
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			sanity.clicksignupWidget();
			sanity.Registration(obj);

			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child2);
				CommonFunctions.info(child2, "Verify Follow Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				Thread.sleep(2000);
				sanity.verifyFollow();
			} catch (Exception e) {
			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child3);
				CommonFunctions.info(child3, "Verify UpVote Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				Thread.sleep(2000);
				sanity.verifyupvote();
			} catch (Exception e) {
			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child4);
				CommonFunctions.info(child4, "Verify DownVote Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				Thread.sleep(2000);
				sanity.verifydownvote();
			} catch (Exception e) {
			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child5);
				CommonFunctions.info(child5, "Verify Follower Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				Thread.sleep(2000);
				sanity.clickDiscussionTab();
				sanity.clickFolowers();
				sanity.verifyFolowers();
				sanity.clickFollowonLayer();
			} catch (Exception e) {
			}
			String comment = "Is there any scope of design in India";
			String commenturl = "";
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child6);
				CommonFunctions.info(child6, "Comment Posting Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);

				sanity.clickDiscussionTab();
				sanity.clickCommentAnswerButton();
				sanity.typeDiscussionComment2(comment);
				sanity.clickPostAnswerComment2();
				commenturl = driver.getCurrentUrl();
				driver.navigate().refresh();
				sanity.verifyCommentAnswerText(comment);

			} catch (Exception r) {
			} finally {
				if (commenturl.length() > 1) {
					// // Delete comment
					sanity = new Sanity_QA_Desktop(obj, driver, child61);
					CommonFunctions.info(child61, "Discussion delete "
							+ " for url : " + FinalUrl);
					driver.get(commenturl);
					CommonFunctions.acceptCookie(driver);

					sanity.clickEditoverFlowLayer2();
					sanity.deletecommentanswer();
					sanity.performAction();
					Thread.sleep(20000);
					driver.navigate().refresh();
					sanity.verifyCommentAnswerTexwt(comment);
				}
			}
			String answer = "Is there any scope of design in India";
			sanity = new Sanity_QA_Desktop(obj, driver, child7);
			CommonFunctions.info(child7, "Answer Posting Test Case "
					+ " for url : " + FinalUrl);
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			String ansurkl = "";
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child71);
				CommonFunctions.info(child61, "Anserr delete " + " for url : "
						+ FinalUrl);
				sanity.clickAnswerTab();
				sanity.clickCommentAnswerButton();
				sanity.typeQuestionAnswer(answer);
				sanity.clickPostAnswerComment();
				sanity.verifyCommentAnswerText(answer);
				ansurkl = driver.getCurrentUrl();
			} catch (Exception d) {
			} finally {
				if (ansurkl.length() > 1) {
					// // Delete answer
					driver.get(ansurkl);
					CommonFunctions.acceptCookie(driver);
					sanity.clickEditoverFlowLayer2();
					sanity.deletecommentanswer();
					sanity.performAction();
					Thread.sleep(20000);
					sanity.verifyCommentAnswerTexwt(answer);
				}
			}

			// // Pagination
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child8);
				CommonFunctions.info(child8, "Pagination Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.checkPagination(FinalUrl);
			} catch (Exception e) {
				// // dO nOTHING
			}

			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child9);
				CommonFunctions.info(child9, "Pagination Test Case "
						+ " for url : " + FinalUrl);
				// // Related Tags
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.relatedTag();
			} catch (Exception e) {

			}

			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child10);
				CommonFunctions.info(child10, "Pagination Test Case "
						+ " for url : " + FinalUrl);
				// // Top contributer
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.contributor();
			} catch (Exception e) {

			}

		}

		catch (Exception e) {

		} finally {
			CommonFunctions.closeChild(parent, child1, report);
			CommonFunctions.closeChild(parent, child2, report);
			CommonFunctions.closeChild(parent, child3, report);
			CommonFunctions.closeChild(parent, child4, report);
			CommonFunctions.closeChild(parent, child5, report);
			CommonFunctions.closeChild(parent, child6, report);
			CommonFunctions.closeChild(parent, child61, report);
			CommonFunctions.closeChild(parent, child7, report);
			CommonFunctions.closeChild(parent, child71, report);
			CommonFunctions.closeChild(parent, child8, report);
			CommonFunctions.closeChild(parent, child9, report);
			CommonFunctions.closeChild(parent, child10, report);

		}

	}

	public void AnA_All_Tag_Page(Objects obj) throws Exception {
		CommonFunctions CommonFunctions = new CommonFunctions(obj);
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String FinalUrl = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunctions.createChild(report,
				"Check pagination",
				"Test Case Check pagination for Tag Page Started");
		ExtentTest child2 = CommonFunctions.createChild(report, "Search Tag",
				"Test Case Search Tag for Tag Page Started");
		FinalUrl = FinalUrl + "tags";
		try {
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child1);
				CommonFunctions.info(child1,
						"Check pagination for Tag Page Test Case "
								+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				// // Pagination
				sanity.checkPagination(FinalUrl);
			} catch (Exception e) {

			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child2);
				CommonFunctions.info(child2,
						"Search Tag for Tag Page Test Case " + " for url : "
								+ FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				// // Search
				sanity.tagSearch();
			} catch (Exception e) {
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);
			CommonFunctions.closeChild(parent, child2, report);

		}

	}

	public void AnA_Question_Detail_Page(Objects obj) throws Exception {
		CommonFunctions CommonFunctions = new CommonFunctions(obj);
		String questionUrl = "";
		String answer = "Is there any scope of design in India";
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String FinalUrl = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunctions.createChild(report,
				"Registeration Widget",
				"Test Case login Action on Registeration Widget Started");
		ExtentTest child2 = CommonFunctions.createChild(report,
				"Question Posting", "Test Case Question Posting Started");
		ExtentTest child3 = CommonFunctions.createChild(report, "Edit Tags",
				"Test Case Edit Tags Started");
		ExtentTest delques = CommonFunctions.createChild(report,
				"Delete Question", "Test Case delete Question Started");
		ExtentTest closeques = CommonFunctions.createChild(report,
				"Close Question", "Test Case close Question Started");
		ExtentTest child4 = CommonFunctions.createChild(report,
				"Edit Question", "Test Case Edit Question Started");
		ExtentTest child7 = CommonFunctions.createChild(report,
				"Question Answer", "Test Case to ansewer a question Started");
		ExtentTest delans = CommonFunctions.createChild(report,
				"Delete Answer", "Test Case Delete Answer Started");
		ExtentTest ansreply = CommonFunctions.createChild(report,
				"Answer Reply", "Test Case Answer Reply Started");
		ExtentTest follow = CommonFunctions.createChild(report, "Follow",
				"Test Case Follow Started");
		ExtentTest abuse = CommonFunctions.createChild(report, "Report Abuse",
				"Test Case Report Abuse Started");
		ExtentTest later = CommonFunctions.createChild(report, "Answer Later",
				"Test Case Answer Later Started");

		if (FinalUrl.contains("www")) {
			String str = FinalUrl;
			str = str.replace("www", "ask");
			FinalUrl = str;
		} else {
			String str = FinalUrl;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			FinalUrl = "https://ask." + uuu;
			System.out.print(FinalUrl);
		}
		try {
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();

			sanity = new Sanity_QA_Desktop(obj, driver, child1);
			CommonFunctions.info(child1, "Registration Test Case "
					+ " for url : " + FinalUrl);
			sanity.clickReigstrationWidget();

			// // Registration flow
			sanity.Registration(obj);

			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child2);
				CommonFunctions.info(child2, "Question Posting Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.ClickQnATextBox("Scope of BBA in India over Nursing");
				sanity.ClickQnADescription();
				sanity.ClickQnADescriptionDetails("Scope of BBA in India over Nursing or Travel");
				sanity.clickNextButton();
				Thread.sleep(2000);
				sanity.clickaddMoreTags();
				Thread.sleep(2000);
				sanity.clickTagSearch("MBA");
				sanity.clicktag();
				Thread.sleep(2000);
				sanity.clicktagdone();
				sanity.clickPostQnA();
				sanity.verifyTags("MBA");
				questionUrl = driver.getCurrentUrl();
				sanity.verifyquestionTitle("Scope of BBA in India over Nursing");
				sanity.verifyDescription("Scope of BBA in India over Nursing or Travel");

				try {
					sanity = new Sanity_QA_Desktop(obj, driver, child3);
					CommonFunctions.info(child3, "Edit Tags Test Case "
							+ " for url : " + questionUrl);
					sanity.clickEditoverFlowLayer();
					Thread.sleep(2000);
					sanity.clickEditTags();
					Thread.sleep(2000);
					sanity.clickaddMoreTags();
					Thread.sleep(2000);
					sanity.clickTagSearch("B.Tech");
					sanity.clicktag();
					sanity.clicktagdone();
					sanity.clickPostQnA();
					sanity.verifyTags("B.Tech");
				} catch (Exception r) {

				}
				try {
					sanity = new Sanity_QA_Desktop(obj, driver, child4);
					CommonFunctions.info(child4, "Question Edit Test Case "
							+ " for url : " + questionUrl);
					sanity.clickEditoverFlowLayer();
					Thread.sleep(2000);
					sanity.clickQuestion();
					Thread.sleep(2000);
					sanity.ClickQnATextBox(" or Engineering");
					sanity.ClickQnADescriptionDetails(" or any other Field over BBA");
					sanity.clickNextButton();
					sanity.clickaddMoreTags();
					sanity.clickTagSearch("Design");
					sanity.clicktag();
					sanity.clicktagdone();
					sanity.clickPostQnA();
					sanity.verifyquestionTitle("Scope of BBA in India over Nursing or Engineering");
					sanity.verifyDescription("Scope of BBA in India over Nursing or Travel or any other Field over BBA");
					sanity.verifyTags("Design");
				} catch (Exception r) {

				}

				sanity = new Sanity_QA_Desktop(obj, driver, child7);
				CommonFunctions.info(child7, "Answer Posting Test Case "
						+ " for url : " + questionUrl);
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				String ansurkl = "";
				try {
					sanity.clickAnswerTab();
					sanity.clickCommentAnswerButton();
					sanity.typeQuestionAnswer(answer);
					sanity.clickPostAnswerComment();
					ansurkl = driver.getCurrentUrl();
					driver.navigate().refresh();
					sanity.verifyCommentAnswerText(answer);

					try {
						// // Comment Reply
						sanity = new Sanity_QA_Desktop(obj, driver, ansreply);
						CommonFunctions.info(ansreply,
								"Reply on answer Test Case " + " for url : "
										+ questionUrl);
						driver.navigate().refresh();
						sanity.clickComment();
						sanity.TypeComment("Design scope is increasing");
						sanity.clickPostAnswerComment();

					} catch (Exception e) {

					}

				} catch (Exception d) {

				} finally {
					if (ansurkl.length() > 1) {
						// // Delete answer
						sanity = new Sanity_QA_Desktop(obj, driver, delans);
						CommonFunctions.info(delans, "Delete answer :"
								+ " for url : " + questionUrl);
						driver.get(ansurkl);
						CommonFunctions.acceptCookie(driver);
						sanity.clickEditoverFlowLayer2();
						sanity.deletecommentanswer();
						sanity.performAction();
						Thread.sleep(20000);
						driver.navigate().refresh();
						sanity.verifyCommentAnswerTexwt(answer);
					}
				}

				try {
					// // Follow
					driver.navigate().refresh();
					sanity = new Sanity_QA_Desktop(obj, driver, follow);
					CommonFunctions.info(follow, "Follow Test case "
							+ " for url : " + FinalUrl);
					sanity.verifyFollow();
				} catch (Exception e) {

				}

				try {
					// // Answer Later
					driver.navigate().refresh();
					sanity = new Sanity_QA_Desktop(obj, driver, later);
					CommonFunctions.info(later, "Answer Later Test case "
							+ " for url : " + questionUrl);
					sanity.clickEditoverFlowLayer();
					sanity.commentlater();
					Thread.sleep(2000);
					driver.navigate().refresh();
					// // Verify comment later
					sanity.clickEditoverFlowLayer();
					sanity.verifyclickabuselayer();

					// // Report Abuses
					driver.navigate().refresh();
					sanity = new Sanity_QA_Desktop(obj, driver, abuse);
					CommonFunctions.info(abuse, "Report Abuse Test case "
							+ " for url : " + questionUrl);
					if (obj.getdbURL().length() < 1)
						CommonFunctions.info(abuse,
								"Not Executing Report Abuse for Live "
										+ " for url : " + FinalUrl);
					else {
						sanity.clickEditoverFlowLayer();
						sanity.clickabuselayer();
						sanity.clickabuselayerother();
						sanity.clickabuselayertext("Not able to understand question");
						sanity.clickabusedone();
						// // verify abuse

						sanity.clickEditoverFlowLayerverity();

					}
				} catch (Exception e) {

				}

			} catch (Exception e) {

			} finally {
				if (questionUrl.length() > 1) {

					driver.get(questionUrl);
					CommonFunctions.acceptCookie(driver);
					// // Close Question
					sanity = new Sanity_QA_Desktop(obj, driver, closeques);
					CommonFunctions.info(closeques, "Close question :"
							+ " for url : " + questionUrl);
					driver.navigate().refresh();
					sanity.clickEditoverFlowLayer();
					sanity.closequestion();
					sanity.performAction();
					sanity.closeques();

					sanity = new Sanity_QA_Desktop(obj, driver, delques);
					CommonFunctions.info(delques, "Delete question :"
							+ " for url : " + questionUrl);
					driver.navigate().refresh();
					sanity.clickEditoverFlowLayer();
					sanity.closequestion();
					sanity.performAction();
					Thread.sleep(20000);
					sanity.verify(FinalUrl);
				}
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);
			CommonFunctions.closeChild(parent, child2, report);
			CommonFunctions.closeChild(parent, child3, report);
			CommonFunctions.closeChild(parent, child4, report);
			CommonFunctions.closeChild(parent, child7, report);
			CommonFunctions.closeChild(parent, ansreply, report);
			CommonFunctions.closeChild(parent, delans, report);
			CommonFunctions.closeChild(parent, follow, report);
			CommonFunctions.closeChild(parent, abuse, report);
			CommonFunctions.closeChild(parent, later, report);
			CommonFunctions.closeChild(parent, closeques, report);
			CommonFunctions.closeChild(parent, delques, report);

		}
	}

	public void AnA_Discussion_Detail_Page(Objects obj) throws Exception {
		CommonFunctions CommonFunctions = new CommonFunctions(obj);
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String FinalUrl = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunctions.createChild(report, "Registration",
				"Test Case Registration Started");
		ExtentTest child2 = CommonFunctions.createChild(report,
				"Discussion Comment", "Test Case Discussion Comment Started");
		ExtentTest delcomm = CommonFunctions.createChild(report,
				"Discussion Delete Comment",
				"Test Case Discussion Comment Delete Started");
		ExtentTest abuse = CommonFunctions.createChild(report, "Report Abuse",
				"Test Case Report Abuse Started");
		ExtentTest later = CommonFunctions.createChild(report, "Answer Later",
				"Test Case Answer Later Started");
		ExtentTest follow = CommonFunctions.createChild(report, "Follow",
				"Test Case Follow Started");
		ExtentTest reply = CommonFunctions.createChild(report, "Reply",
				"Test Case Reply Started");
		ExtentTest delreply = CommonFunctions.createChild(report,
				"Delete Reply", "Test Case Delete Reply Started");
		ExtentTest Pagi = CommonFunctions.createChild(report, "Pagination",
				"Test Case Pagination Started");
		if (FinalUrl.contains("www")) {
			String str = FinalUrl;
			str = str.replace("www", "ask");
			FinalUrl = str;
		} else {
			String str = FinalUrl;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			FinalUrl = "https://ask." + uuu;
			System.out.print(FinalUrl);
		}
		try {
			sanity = new Sanity_QA_Desktop(obj, driver, child1);
			CommonFunctions.info(child1, "Registration Test Case "
					+ " for url : " + FinalUrl);
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			sanity.clickReigstrationWidget();

			// // Registration flow
			sanity.Registration(obj);

			sanity = new Sanity_QA_Desktop(obj, driver, child2);
			CommonFunctions.info(delcomm, "Discussion Comment :"
					+ " for url : " + FinalUrl);
			String comment = "Scope of Design in India";
			String commenturl = "";
			try {
				driver.get(FinalUrl);
				CommonFunctions.acceptCookie(driver);
				sanity.clickDiscussionTab();
				sanity.clickCommentAnswerButton();
				sanity.typeDiscussionComment(comment);
				sanity.clickPostAnswerComment();
				commenturl = driver.getCurrentUrl();
				driver.navigate().refresh();
				sanity.verifyCommentAnswerText(comment);
			}

			catch (Exception e) {

			} finally {
				if (commenturl.length() > 1) {
					sanity = new Sanity_QA_Desktop(obj, driver, delcomm);
					CommonFunctions.info(delcomm, "Delete comment :"
							+ " for url : " + FinalUrl);
					// // Delete comment
					driver.get(commenturl);
					sanity.clickEditoverFlowLayer2();
					sanity.deletecommentanswer();
					sanity.performAction();
					Thread.sleep(20000);
					driver.navigate().refresh();
					sanity.verifyCommentAnswerTexwt(comment);
				}
				try {
					// // Answer Later
					driver.navigate().refresh();
					sanity = new Sanity_QA_Desktop(obj, driver, later);
					CommonFunctions.info(later, "Answer Later Test case "
							+ " for url : " + commenturl);
					sanity.clickEditoverFlowLayer();
					sanity.commentlater();
					Thread.sleep(2000);
					driver.navigate().refresh();
					// // Verify comment later
					sanity.clickEditoverFlowLayer();
					sanity.verifyclickabuselayer();

					// // Report Abuses
					driver.navigate().refresh();
					sanity = new Sanity_QA_Desktop(obj, driver, abuse);
					CommonFunctions.info(abuse, "Report Abuse Test case "
							+ " for url : " + FinalUrl);
					if (obj.getdbURL().length() < 1)
						CommonFunctions.info(abuse,
								"Not Executing Report Abuse for Live "
										+ " for url : " + commenturl);
					else {
						sanity.clickEditoverFlowLayer();
						sanity.clickabuselayer();
						sanity.clickabuselayerother();
						sanity.clickabuselayertext("Not able to understand question");
						sanity.clickabusedone();
						// // verify abuse
						sanity.clickEditoverFlowLayerverity();
					}
				}

				catch (Exception e) {

				}
				try {
					// // Follow
					driver.navigate().refresh();
					sanity = new Sanity_QA_Desktop(obj, driver, follow);
					CommonFunctions.info(follow, "Follow Test case "
							+ " for url : " + commenturl);
					sanity.verifyFollow();
				} catch (Exception e) {

				}
				String replytet = "Scope of Design in India";
				String replyurl = "";
				try {
					sanity = new Sanity_QA_Desktop(obj, driver, reply);
					CommonFunctions.info(reply, "Reply Test case "
							+ " for url : " + commenturl);
					// //Reply
					sanity.clickComment();
					sanity.TypeComment(replytet);
					sanity.clickPostAnswerComment();
					replyurl = driver.getCurrentUrl();
					driver.navigate().refresh();
					sanity.clickReply();
					sanity.verifyreply(replytet);

				} catch (Exception e) {
				} finally {
					sanity = new Sanity_QA_Desktop(obj, driver, delreply);
					CommonFunctions.info(delreply, "Delete Reply Test case "
							+ " for url : " + commenturl);
					driver.get(replyurl);
					sanity.clickReply();
					sanity.deletequestion();
					sanity.performAction();
					Thread.sleep(20000);
					sanity.clickReply2();
				}

				try {
					sanity = new Sanity_QA_Desktop(obj, driver, Pagi);
					CommonFunctions.info(Pagi, "Pagination Test case "
							+ " for url : " + commenturl);
					if (commenturl.length() > 1) {
						driver.get(commenturl);
						sanity.checkPagination2(commenturl);
					} else
						CommonFunctions.fail(Pagi, "Pagination not verified"
								+ " for url : " + commenturl + " No url exist");
				} catch (Exception e) {
				}
			}

		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);
			CommonFunctions.closeChild(parent, child2, report);
			CommonFunctions.closeChild(parent, delcomm, report);
			CommonFunctions.closeChild(parent, abuse, report);
			CommonFunctions.closeChild(parent, later, report);
			CommonFunctions.closeChild(parent, follow, report);
			CommonFunctions.closeChild(parent, reply, report);
			CommonFunctions.closeChild(parent, delreply, report);
			CommonFunctions.closeChild(parent, Pagi, report);
		}

	}

	public void AnA_All_Question_Page(Objects obj) throws Exception {
		CommonFunctions CommonFunctions = new CommonFunctions(obj);
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String FinalUrl = obj.getURL();
		WebDriver driver = obj.getDriver();
		if (FinalUrl.contains("www")) {
			String str = FinalUrl;
			str = str.replace("www", "ask");
			FinalUrl = str;
		} else {
			String str = FinalUrl;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			FinalUrl = "https://ask." + uuu;
			System.out.print(FinalUrl);
		}
		FinalUrl = FinalUrl + "questions";

		ExtentTest follow = CommonFunctions.createChild(report, "Follow",
				"Test Case Follow Started");
		ExtentTest child1 = CommonFunctions.createChild(report,
				"Registeration Widget",
				"Test Case login Action on Registeration Widget Started");
		ExtentTest child15 = CommonFunctions.createChild(report, "UpVote",
				"Test Case UpVote Started");
		ExtentTest child16 = CommonFunctions.createChild(report, "DownVote",
				"Test Case DownVote Started");
		ExtentTest child17 = CommonFunctions.createChild(report, "Followers",
				"Test Case Followers Started");
		ExtentTest child7 = CommonFunctions.createChild(report,
				"Answer Posting", "Test Case Answer Posting Started");
		ExtentTest child99 = CommonFunctions.createChild(report,
				"Delete Answer", "Test Case Delete Answer Started");
		ExtentTest pagi = CommonFunctions.createChild(report, "Pagination",
				"Test Case Pagination Started");
		try {
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			sanity = new Sanity_QA_Desktop(obj, driver, child1);
			CommonFunctions.info(child1, "Registration Test Case "
					+ " for url : " + FinalUrl);
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			sanity.clickReigstrationWidget();
			// // Registration flow
			sanity.Registration(obj);
			try {
				// // Follow
				driver.get(FinalUrl);
				sanity = new Sanity_QA_Desktop(obj, driver, follow);
				CommonFunctions.info(follow, "Follow Test case "
						+ " for url : " + FinalUrl);
				sanity.verifyFollow();
			} catch (Exception e) {
			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child15);
				driver.get(FinalUrl);
				CommonFunctions.info(child15, "Upvote  Test Case "
						+ " for url : " + FinalUrl);
				Thread.sleep(2000);
				sanity.verifyupvote();
			} catch (Exception e) {

			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child16);
				driver.get(FinalUrl);
				CommonFunctions.info(child16, "Downvote Test Case "
						+ " for url : " + FinalUrl);
				Thread.sleep(2000);
				sanity.verifydownvote();
			} catch (Exception er) {
			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child17);
				CommonFunctions.info(child17, "Followers Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				Thread.sleep(2000);
				sanity.clickFolowers_2();
				sanity.verifyFolowers();
				sanity.clickFollowonLayer();
			} catch (Exception r) {
			}

			// // Answer
			String answer = "Is there any scope of design in India";
			String ansurkl = "";
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child7);
				CommonFunctions.info(child7, "Answer Posting Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				sanity.clickCommentAnswerButton();
				sanity.typeQuestionAnswer(answer);
				sanity.clickPostAnswerComment();
				ansurkl = driver.getCurrentUrl();
				driver.navigate().refresh();
				sanity.verifyCommentAnswerText(answer);

			} catch (Exception r) {
			} finally {
				if (ansurkl.length() > 1) {
					// // Delete answer
					sanity = new Sanity_QA_Desktop(obj, driver, child99);
					CommonFunctions.info(child99, "Delete anseer :"
							+ " for url : " + FinalUrl);
					driver.get(ansurkl);
					sanity.clickEditoverFlowLayer2();
					sanity.deletecommentanswer();
					sanity.performAction();
					Thread.sleep(20000);
					driver.navigate().refresh();
					sanity.verifyCommentAnswerTexwt(answer);
				}
			}

			// // Pagination
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, pagi);
				CommonFunctions.info(pagi,
						"Check pagination for Tag Page Test Case "
								+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				// // Pagination
				sanity.checkPagination2(FinalUrl);
			} catch (Exception e) {
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);
			CommonFunctions.closeChild(parent, follow, report);
			CommonFunctions.closeChild(parent, child15, report);
			CommonFunctions.closeChild(parent, child16, report);
			CommonFunctions.closeChild(parent, child17, report);
			CommonFunctions.closeChild(parent, child7, report);
			CommonFunctions.closeChild(parent, child99, report);
			CommonFunctions.closeChild(parent, pagi, report);
		}
	}

	public void AnA_All_Discussion_Page(Objects obj) throws Exception {
		CommonFunctions CommonFunctions = new CommonFunctions(obj);
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String FinalUrl = obj.getURL();
		WebDriver driver = obj.getDriver();
		if (FinalUrl.contains("www")) {
			String str = FinalUrl;
			str = str.replace("www", "ask");
			FinalUrl = str;
		} else {
			String str = FinalUrl;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			FinalUrl = "https://ask." + uuu;
			System.out.print(FinalUrl);
		}
		FinalUrl = FinalUrl + "all-discussions/06082018";

		ExtentTest follow = CommonFunctions.createChild(report, "Follow",
				"Test Case Follow Started");
		ExtentTest child1 = CommonFunctions.createChild(report,
				"Registeration Widget",
				"Test Case login Action on Registeration Widget Started");
		ExtentTest child15 = CommonFunctions.createChild(report, "UpVote",
				"Test Case UpVote Started");
		ExtentTest child16 = CommonFunctions.createChild(report, "DownVote",
				"Test Case DownVote Started");
		ExtentTest child17 = CommonFunctions.createChild(report, "Followers",
				"Test Case Followers Started");
		ExtentTest child7 = CommonFunctions.createChild(report,
				"Answer Posting", "Test Case Answer Posting Started");
		ExtentTest child99 = CommonFunctions.createChild(report,
				"Delete Answer", "Test Case Delete Answer Started");

		try {
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			sanity = new Sanity_QA_Desktop(obj, driver, child1);
			CommonFunctions.info(child1, "Registration Test Case "
					+ " for url : " + FinalUrl);
			driver.manage().deleteAllCookies();
			driver.get(FinalUrl);
			CommonFunctions.acceptCookie(driver);
			driver.manage().deleteAllCookies();
			sanity.clickReigstrationWidget();
			// // Registration flow
			sanity.Registration(obj);
			try {
				// // Follow
				driver.get(FinalUrl);
				sanity = new Sanity_QA_Desktop(obj, driver, follow);
				CommonFunctions.info(follow, "Follow Test case "
						+ " for url : " + FinalUrl);
				sanity.verifyFollow();
			} catch (Exception e) {
			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child15);
				driver.get(FinalUrl);
				CommonFunctions.info(child15, "Upvote  Test Case "
						+ " for url : " + FinalUrl);
				Thread.sleep(2000);
				sanity.verifyupvote();
			} catch (Exception e) {

			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child16);
				driver.get(FinalUrl);
				CommonFunctions.info(child16, "Downvote Test Case "
						+ " for url : " + FinalUrl);
				Thread.sleep(2000);
				sanity.verifydownvote();
			} catch (Exception er) {
			}
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child17);
				CommonFunctions.info(child17, "Followers Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				Thread.sleep(2000);
				sanity.clickFolowers_2();
				sanity.verifyFolowers();
				sanity.clickFollowonLayer();
			} catch (Exception r) {
			}

			// // Answer
			String answer = "Is there any scope of design in India";
			String ansurkl = "";
			try {
				sanity = new Sanity_QA_Desktop(obj, driver, child7);
				CommonFunctions.info(child7, "Answer Posting Test Case "
						+ " for url : " + FinalUrl);
				driver.get(FinalUrl);
				sanity.clickCommentAnswerButton();
				sanity.typeDiscussionComment(answer);
				sanity.clickPostAnswerComment();
				ansurkl = driver.getCurrentUrl();
				driver.navigate().refresh();
				sanity.verifyCommentAnswerText(answer);

			} catch (Exception r) {
			} finally {
				if (ansurkl.length() > 1) {
					// // Delete answer
					sanity = new Sanity_QA_Desktop(obj, driver, child99);
					CommonFunctions.info(child99, "Delete anseer :"
							+ " for url : " + FinalUrl);
					driver.get(ansurkl);
					sanity.clickEditoverFlowLayer2();
					sanity.deletecommentanswer();
					sanity.performAction();
					Thread.sleep(20000);
					driver.navigate().refresh();
					sanity.verifyCommentAnswerTexwt(answer);
				}
			}

		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);
			CommonFunctions.closeChild(parent, follow, report);
			CommonFunctions.closeChild(parent, child15, report);
			CommonFunctions.closeChild(parent, child16, report);
			CommonFunctions.closeChild(parent, child17, report);
			CommonFunctions.closeChild(parent, child7, report);
			CommonFunctions.closeChild(parent, child99, report);
		}
	}
}
