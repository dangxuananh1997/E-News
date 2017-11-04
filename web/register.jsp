<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>E-News - Register</title>
	<link rel="stylesheet" type="text/css" href="css/register.css">
	<script src="js/config.js"></script>
    <script type="text/javascript" src="jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="js/register.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container">
		<h2>Register</h2>
        <form class="register-form" id="registerForm" action="registerUser" method="POST">
            <div class="form-group <s:if test="%{error != null && error != ''}">has-danger</s:if>">
				<label for="email">Email:</label>
				<input class="form-control" type="text" name="email" value="<s:property value="%{email}"/>">
                <s:if test="%{error != null && error != ''}">
                    <label id="email-error" class="help-block" for="email"><s:property value="%{error}"/></label>
                </s:if>
			</div>
			<div class="form-group">
				<label for="name">Full Name:</label>
                <input class="form-control" type="text" name="name" value="<s:property value="%{name}"/>">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input class="form-control" type="password" name="password" id="password">
			</div>
			<div class="form-group">
				<label for="passwordConfirm">Confirm Password:</label>
				<input class="form-control" type="password" name="passwordConfirm">
			</div>
			<div class="form-group">
				<label for="code">Security Code:</label>
				<input class="form-control" type="text" name="code">
			</div>
			<div class="security-code">
				50M3C0D3
			</div>
			<input type="hidden" id="code" value="123">
			<textarea rows="3" readonly>Information We Automatically Collect 

We and our third-party service providers (including any third-party content, advertising, and analytics providers) may automatically collect certain information from your device or web browser when you interact with the Services to help us understand how our users use the Services and to target advertising to you (which we will refer to in this Privacy Policy collectively as "Usage Data"). For example, each time you visit the Services we and our third-party service providers may automatically collect your IP address, mobile device identifier or other unique identifier, browser and computer type, access time, the Web page you came from, the URL you go to next, the Web page(s) that you access during your visit and your interaction with content or advertising on the Services. 

We and our third-party service providers may use such Usage Data for a variety of purposes including to diagnose problems with our servers and software, to administer the Services, to gather demographic information and to target advertising to you on the Services and elsewhere online. Accordingly, our third-party advertising networks and ad servers will also provide us with information, including reports that will tell us how many ads were presented and clicked on the Services in a manner that does not identify personally any specific individual. The Usage Data we collect is generally non-identifying, but if we associate it with you as a specific and identifiable person, we will treat it as Personal Data.
Cookies/Tracking Technologies

We may use tracking technologies, such as cookies, local storage, and pixel tags.

Cookies and Local Storage 

Cookies and local storage may be set and accessed on your computer. Upon your first visit to the Services, a cookie or local storage may be sent to your computer that uniquely identifies your browser. "Cookies" and local storage are small files containing a string of characters that is sent to your computer's browser and stored on your device when you visit a website. Many major Web services use cookies to provide useful features for their users. Each Web site can send its own cookie to your browser. Most browsers are initially set up to accept cookies. You can reset your browser to refuse all cookies or to indicate when a cookie is being sent; however, if you reject cookies, you will not be able to sign in to the Services or take full advantage of our Services. Additionally, if you clear all cookies on your browser at any point after setting your browser to refuse all cookies or indicate when a cookie is being sent, you will have to again reset your browser to refuse all cookies or indicate when a cookie is being sent. 

You can find more information about cookies and how they work, what cookies have been set on your computer or mobile device and how to manage and delete them at http://www.allaboutcookies.org/ and www.youronlinechoices.com/uk. 

Flash 

A Flash cookie is a data file placed on a device via the Adobe Flash plug-in that may be built into or downloaded by you onto your device. Flash cookies may be used for various purposes, including, without limitation, enabling a Flash feature and remembering your preferences. For more information about Flash and the privacy choices Adobe offers, visit http://www.macromedia.com/support/documentation/en/flashplayer/help/settings_manager.html. If you choose to adjust your Flash privacy settings on your device some features of the Services may not function properly. 

Pixel Tags 

We may also use "pixel tags," which are small graphic files that allow us and third parties to monitor the use of the Services and collect Usage Data. A pixel tag can collect information such as the IP address of the computer that downloaded the page on which the tag appears; the URL of the page on which the pixel tag appears; the time (and length of time) the page containing the pixel tag was viewed; the type of browser that retrieved the pixel tag; and the identification number of any cookie previously placed by that server on your computer. 

We may use pixel tags, either provided by us or by our third party advertisers, service providers and ad networks, to collect information about your visit, including the pages you view, the links you click and other actions taken in connection with our sites and Services and use them in combination with our cookies to provide offers and information of interest to you. Pixel tags may also enable ad networks to serve targeted advertisements to you when you visit the Services or other websites. 

In addition, we may use a variety of other technologies that collect similar information for security and fraud detection purposes.
Information You Choose To Submit

You can visit the Services without telling us who you are or revealing any information by which someone could identify you as a specific, identifiable individual (which we will refer to in this Privacy Policy collectively as "Personal Data"). If, however, you wish to register to become a member of the Services, you are required to provide certain Personal Data (for example, your name and e-mail address), and you must also provide a user name and password. We use your Personal Data to fulfil your requests for products and services, to improve our Services, to contact you from time to time, with your consent, about us and our products and services, and as otherwise described in this Privacy Policy. You may also choose to submit or we may collect additional information about yourself, such as demographic information (for example your gender, birth date, or zip code) and information about your preferences and interests. We refer collectively to all information we collect that is not Personal Data, including Usage Data, demographic data and de-identified Personal Data, as "Non-Personal Data". If we combine Non-Personal Data with Personal Data, we will treat the combined information as Personal Data under this Privacy Policy. You also may choose to submit your alias, bio, email, photos or any other information that you would like to share with other users of the Services (which we will refer to in this Privacy Policy collectively as "User Submissions"). Personal Data, Non-Personal Data, and User Submissions are referred to in this Privacy Policy collectively as "User Information"

Information We Receive From Other Sources

We may supplement the information we collect with outside records in order to learn more about our users, to better tailor the content and offers we show you, and for other purposes. We may receive this information about you from third parties, including without limitation consumer data resellers and advertisers. We may combine the information we receive from those other sources with information we collect through the Services. In those cases, we will apply this Privacy Policy to the combined information.
Information Use

We may use the information we collect, including Personal Data and Usage Data: 
- to enable you to use our Services, to create an account or profile, to process information you provide via our Services (including verifying that your email address is active and valid) and to process your transactions; 
- to provide related customer service and care, including responding to your questions, complaints, or comments and sending surveys (with your consent) and processing survey responses 
- to provide you with information, products, or services that you have requested; 
- with your consent, to provide you with information, products, or services that we otherwise believe will interest you, including special opportunities from us and our third-party partners. 
- to tailor content, recommendations, and advertisements we and third parties display to you, both on the Services and elsewhere online; 
- for internal business purposes, such as to improve our Services; 
- to administer and process contests, sweepstakes, and promotions; 
- to contact you with administrative communications and, in our discretion, changes to our Privacy Policy, Terms of Use, or any of our other policies; 
- to comply with regulatory and legal obligations; and 
- for purposes as disclosed at the time you provide your information, with your consent, and as further described in this Privacy Policy.
Social Network and Platform Integration
The Services may contain integration with social networks and other platforms in which information is shared between us and such platforms. For example, if you create or log into your account through a third party social media site, we will have access to certain information from that site, such as your name, email address, account information, photo and friends lists, and other information in accordance with the authorisation procedures determined by such social media site. If you visit our Services on a device through which you also interact with social networks or if you interact with us through a social media function such as a plug-in (for example, a Facebook "like" button) then you permit us to have on-going access to, to use and to store some information from your social network profile (such as your name, email address, your friend list, photo, age, gender, location, birthday, social networking ID, current city, and the people/sites you follow) in accordance with this Privacy Policy. If you don't want a social network to collect the information about you as described above, or you don't want a social network to share it with us, please review the privacy policy, privacy settings and instructions of the applicable social network before you visit and use our Services.
Our Information Sharing Practice
(i) Generally. We may share Non-Personal Data, including Usage Data, de-identified Personal Data and aggregated user statistics, with third parties in our discretion. We may share User Information, including Personal Data, as otherwise described in this Policy, and under the following circumstances:
(ii) Service Providers. From time to time, we may enter into relationships with third parties who provide services to us (for example, analytics companies, advertisers and ad agencies, data management and storage services or credit card processing services, sweepstakes or contest prize fulfilment). In those circumstances, we disclose User Information so that such service providers may perform those services. These service providers are only permitted to use your Personal Data to the extent necessary to enable them to provide their services to us. They are required to follow our express instructions and to comply with appropriate security measures to protect your Personal Data. 
(iii) Third Party Marketing. You will have a choice (opt-in or opt-out) before we share your information with third parties for marketing purposes. Provided that you have chosen to receive marketing messages from third parties, we may share your information (including Personal Data) with third parties for those third parties' own direct marketing purposes. Please note, messages delivered from a third party will subject you to the third party's privacy policy. We may also match your email address with third parties with whom you have also consented to share your email address and use such match to deliver custom offers or emails to you on the Services and off the Services provided you have consented to receiving such offers or emails 
(iv) In the event we go through a business transition (such as a merger, acquisition by another company, bankruptcy, or sale of all or a portion of our assets, including, without limitation, during the course of any due diligence process), your Personal Data will likely be among the assets transferred. By providing your Personal Data, you agree that we may transfer such information in those circumstances without your further consent. 
(v) Other Disclosure Scenarios. We reserve the right, and you hereby expressly authorise us, to share User Information: (1) in response to subpoenas, court orders, or legal process, or to establish, protect, or exercise our legal rights or defend against legal claims; (2) if we believe it is necessary in order to investigate, prevent, or take action regarding illegal activities, fraud, or situations involving potential threats to the safety of any person or property; (3) if we believe it is necessary to investigate, prevent, or take action regarding significant abuse of the Services infrastructure or the Internet in general (such as voluminous spamming, denial of service attacks, or attempts to compromise the security of information); (4) to protect and defend our legal rights or property, our services or their users, or any other party, and to protect the health and safety of our users or the general public; and (5) to our parent company, subsidiaries, joint ventures, or other companies under common control with us (in which case we will require such entities to honour this Privacy Policy).
Anonymous Data
When we use the term "anonymous data," we are referring to data and information that does not permit you to be identified or identifiable, either alone or when combined with any other information available to a third party. We may create anonymous data from the Personal Data we receive about you and other individuals whose Personal Data we collect. Anonymous data might include analytics information and information collected by us using cookies. We make Personal Data into anonymous data by excluding information (such as your name) that makes the data personally identifiable to you.  We use this anonymous data to analyse usage patterns in order to make improvements to our Services.
Public Information
If you identify any User Information as public, you are authorising us to share such information publicly. For example, you may elect to make certain of your User Submissions (such as your alias, bio, email or photos) publicly available. Also, there may be areas of the Services (for example, message boards, discussion rooms, and other online forums) in which you are able to post information that automatically will be available to all other users of the Services. By choosing to use these areas, you understand and agree that anyone may access, use, and disclose any information that you post to those areas.
Users Outside of the United States and Consent to Transfer

The Services are operated in the United States. If you are located in another jurisdiction, please be aware that information you provide to us will be transferred to, stored and processed in the United States. By using the Services or providing us with any information, you consent to this transfer, processing, and storage of your information in the United States, a jurisdiction in which the privacy laws may not be as comprehensive as those in the country where you reside or are a citizen. We will take all steps reasonably necessary to ensure that your data is treated securely and in accordance with this Privacy Policy.
Important Information for California Residents-Your California Privacy Rights

As stated elsewhere in this Privacy Policy, Vox Media does not share Personal Data with third parties for their direct marketing purposes, as defined by California Civil Code Section 1798.83, unless we give you choice (opt-in or opt-out) before sharing with those third parties. 

If you are a California resident and you have questions about our practices with respect to sharing information with third parties for their direct marketing purposes and your ability to exercise choice, please contact us at Vox Media, Inc., c/o General Counsel, 1201 Connecticut Ave. NW, 11th FL., Washington D.C. 20036. You must put the statement "Your California Privacy Rights" in the body of your request, as well as your name, street address, city, state, and zip code. In the body of your request, please provide enough information for us to determine if this applies to you. Please note that we will not accept inquiries via the telephone, email, or by facsimile, and we are not responsible for notices that are not labelled or sent properly, or that do not have complete information.
How We Respond to "Do Not Track" Signals

Some Internet browsers may be configured to send "Do Not Track" signals to the online services that you visit. California Business & Professions Code Section 22575(b) (as amended effective January 1, 2014) provides that California residents are entitled to know how Vox Media responds to "Do Not Track" browser settings. 

There currently is no consensus among industry participants as to what "Do Not Track" means in this context. Therefore, like many websites and online services, the Services do not alter their practices when they receive a "Do Not Track" signal from a visitor's browser. To find out more about "Do Not Track," please visit http://www.allaboutdnt.com.
Advertising

(a) Generally. We may use other companies under agreements with us to serve third-party advertisements when you visit and use the Services. These companies may collect and use click stream information, browser type, time and date, subject of advertisements clicked or scrolled over during your visits to the Services and other Web sites in order to provide advertisements about goods and services likely to be of greater interest to you. These companies typically use tracking technologies to collect this information. Other companies' use of their tracking technologies is subject to their own privacy policies, not this one.
(b) Targeted Advertising. In order to serve offers and advertisements that may be of interest to our users, we may display targeted advertisements on the Services, or other digital properties or applications in conjunction with our content, based on information provided to us by our users and information provided to us by third parties that they have independently collected. We do not provide Personal Data to our advertisers when you interact with an advertisement.
(c) Your Ad Choices. Some of the third party services providers and/or Advertisers may be members of the Network Advertising Initiative ("NAI") or the Digital Advertising Alliance ("DAA") Self-Regulatory Program for Online Behavioral Advertising. You may want to visit http://www.networkadvertising.org/managing/opt_out.asp, which provides information regarding targeted advertising and the "opt-out" procedures of NAI members. You can opt-out of our use of your Web site viewing behaviour data to serve you interest-based advertising on third-party sites and email newsletters here http://www.aboutads.info/choices/. 

If you are accessing the Services through an application (i.e., mobile phone or tablet) you can download the AppChoices application from your device's application store (i.e., Google Play, Apple App Store, and Amazon Store). This DAA application allows participating companies to offer an opt-out of customised advertisements that are based on predictions about your interests generated from your application usage. For more information, visit http://www.aboutads.info/appchoices

Please note opting out through these mechanisms does not opt you out of being served advertising. You will continue to receive generic ads while online or on your device.

(d) Mobile. We may from time to time offer certain location or pinpoint based services, such as location assisted navigation instruction. If you elect to use such location-based services, we must periodically receive your location in order to provide such location-based services to you. By using the location-based services, you authorise us to: (i) locate your hardware; (ii) record, compile and display your location; and (iii) publish your location to third parties designated by you by means of location publication controls available within the applications (for example, settings, user preferences). As part of the location-based services, we may also collect and store certain information about the users who elect to use such location-based services, such as a device id. This information will be used to provide you the location-based services. We may use third-party providers to help provide location-based services through mobile systems (unless you opt out of such location-based services with such providers) and we may provide the information to such providers to enable them to provide their location-based services, provided that such providers may use the information in accordance with our Privacy Policy.
			</textarea>
			<div class="form-check">
				<label class="form-check-label">
					<input class="form-check-input" type="checkbox" name="acceptTerms">
					I have read understand and accept the terms and conditions. &nbsp;
				</label>
			</div>
			<button class="btn btn-success" type="submit">Register</button>
			<a class="btn btn-info" role="button" href="viewHome">Back to Home</a>
		</form>
	</section>

	<div class="e-footer"></div>
</body>
</html>