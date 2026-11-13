from inspect import Parameter, getmembers, ismethod, signature

import draft


def run(*args):
    methods = [
        method
        for name, method in getmembers(draft.Solution(), ismethod)
        if not name.startswith("_")
    ]
    if len(methods) != 1:
        raise ValueError("Solution 需要恰好一个公开方法，辅助方法可以用 _ 开头")

    method = methods[0]
    if args:
        return method(*args)

    method_signature = signature(method)
    arguments = method_signature.bind_partial()
    draft_values = vars(draft)
    for name, parameter in method_signature.parameters.items():
        if name in draft_values:
            arguments.arguments[name] = draft_values[name]
        elif parameter.default is Parameter.empty and parameter.kind not in (
            Parameter.VAR_POSITIONAL,
            Parameter.VAR_KEYWORD,
        ):
            raise ValueError(f"请在 draft.py 末尾为参数 {name!r} 赋值")

    arguments.apply_defaults()
    return method(*arguments.args, **arguments.kwargs)


if __name__ == "__main__":
    print(run())
