import java.util.Stack;

public class TagCheck {

	public static Stack<String> tagStack = new Stack<>();
	public static Stack<String> printStack = new Stack<>();

	public static Stack<String> getStack() {
		return tagStack;
	}

	public static Stack<String> getPrint() {
		return printStack;
	}

	// Method check starting Tag
	public StringBuilder tagStart(StringBuilder content) {
		String check = content.toString();
		if (check.contains("<")) {
			int start = content.indexOf("<");
			if (!('/' == (content.charAt(start + 1)))) {
				content.delete(0, start + 1);
				String header = getHeader(content);
				tagStack.add(header);
				int end = content.indexOf(">");
				content.delete(0, end + 1);
			} else {
				int end = content.indexOf(">");
				StringBuilder newContent = new StringBuilder();
				newContent.append(content.substring(end + 1, content.length()));
				if (tagStack.size() > 0)
					tagStack.pop();
				tagStart(newContent);
				return newContent;
			}
		} else
			tagStack.add("None");
		return content;
	}

	public String getHeader(StringBuilder content) {
		int end = content.indexOf(">");
		return content.substring(0, end);
	}

	// Method check Ending Tag
	public StringBuilder tagEnd(String header, StringBuilder content) {
		String check = content.toString();
		if (!check.contains("</" + header + ">")) {
			printStack.add("None");
		} else {
			int end1 = check.indexOf("</" + header + ">");
			check = check.substring(0, end1 + 3 + header.length());
			StringBuilder newContent = new StringBuilder();
			newContent.append(content.substring(end1 + 3 + header.length(), content.length()));

			if (check.contains("<")) {
				int start = content.indexOf("<");
				if ('/' == (content.charAt(start + 1))) {
					check = content.substring(0, start);
					content.delete(0, start + 1);
					int end = content.indexOf(">");
					String str = content.substring(1, end);
					if (header.equals(str)) {
						printStack.add(check);
						tagStack.pop();
					}
					content.delete(0, end + 1);
					check = content.toString();
					if (check.contains("<")) {
						try {
							content = tagStart(content);
							header = tagStack.peek();
							content = tagEnd(header, content);
							return content;
						} catch (NullPointerException e) {
							System.out.println("Null Pointer on If tagEnd");
						}
					}
					return newContent;

				} else {
					try {
						while (check.contains("<")) {
							content = tagStart(content);
							header = tagStack.peek();
							content = tagEnd(header, content);
							return content;
						}
					} catch (NullPointerException e) {
						System.out.println("Null Pointer on Else tagEnd");
					}

				}
			}
		}
		return content;
	}

	public void deleteContent(String header) {
		int distance = tagStack.search(header);
		int distance2 = printStack.search(header);
		for (int i = 1; i < distance; i++)
			tagStack.pop();
		for (int i = 1; i < distance2; i++)
			printStack.pop();
	}
}